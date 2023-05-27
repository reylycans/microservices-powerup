package com.pragma.usuarios.domain.usercase;

import com.pragma.usuarios.domain.enums.RolEnum;
import com.pragma.usuarios.domain.exception.DomainException;
import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.domain.port.in.IUserServicePort;
import com.pragma.usuarios.domain.port.out.IRolRepository;
import com.pragma.usuarios.domain.port.out.authentication.IToken;
import com.pragma.usuarios.domain.port.out.IUserRepository;
import com.pragma.usuarios.domain.port.out.authentication.IUserPasswordEncoder;

import java.util.Optional;

public class UserServicePort implements IUserServicePort {

    private final IUserRepository userRepository;
    private final IToken token;
    private final IUserPasswordEncoder userPasswordEncoder;
    private final IRolRepository rolRepository;


    public UserServicePort(IUserRepository userRepository,
                           IToken token,
                           IUserPasswordEncoder userPasswordEncoder,
                           IRolRepository rolRepository
                           ) {
        this.userRepository = userRepository;
        this.token=token;
        this.userPasswordEncoder = userPasswordEncoder;
        this.rolRepository = rolRepository;
    }

    @Override
    public void save(UserModel userModel) {
       validateRol(userModel);
       userModel.setPassword(userPasswordEncoder.encode(userModel.getPassword()));
       try{
           userRepository.save(userModel);
       }catch (Exception e){
           throw new DomainException(e.getMessage());
       }
    }

    @Override
    public UserModel getUserById(Long id) {
        Optional<UserModel> userModel = userRepository.getUserById(id);
        if(!userModel.isPresent()){
            throw new DomainException("User not found");
        }
        return userModel.get();
    }

    @Override
    public UserModel getUserByEmail(String email) {
        Optional<UserModel> userModel = userRepository.getUserByEmail(email);
        if(!userModel.isPresent()){
            throw new DomainException("User not found");
        }
        return userModel.get();
    }

    private void validateRol(UserModel userModel){
        String bearerToken = token.getBearerToken();
        if((bearerToken == null)) throw new DomainException("invalid token.");

        String rol = token.getUserAuthenticationRol(bearerToken);
        switch (rol){
            case "ADMIN":
                userModel.setRol(getRol(RolEnum.OWNER.getValor()));
                break;
            case "OWNER":
                userModel.setRol(getRol(RolEnum.EMPLOYEE.getValor()));
                break;
            case "CUSTOMER":
                userModel.setRol(getRol(RolEnum.CUSTOMER.getValor()));
        }
    }

    private RolModel getRol(Long rolId){
        Optional<RolModel> rolModel = rolRepository.findById(rolId);
        if(!rolModel.isPresent()){
            throw new DomainException("role not found.");
        }
        return rolModel.get();
    }
}
