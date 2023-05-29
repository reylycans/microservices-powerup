package com.pragma.usuarios.domain.usercase;

import com.pragma.usuarios.domain.enums.RolEnum;
import com.pragma.usuarios.domain.exception.DomainException;
import com.pragma.usuarios.domain.model.RestaurantEmployeeModel;
import com.pragma.usuarios.domain.model.RestaurantModel;
import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.domain.port.in.IUserServicePort;
import com.pragma.usuarios.domain.port.out.IRolRepository;
import com.pragma.usuarios.domain.port.out.authentication.IToken;
import com.pragma.usuarios.domain.port.out.IUserRepository;
import com.pragma.usuarios.domain.port.out.authentication.IUserPasswordEncoder;
import com.pragma.usuarios.domain.port.out.feignclients.IRestaurantEmployeeFeignClientRepository;
import com.pragma.usuarios.domain.port.out.feignclients.IRestaurantFeignClientRepository;

import java.util.Optional;

public class UserServicePort implements IUserServicePort {

    private final IUserRepository userRepository;
    private final IToken token;
    private final IUserPasswordEncoder userPasswordEncoder;
    private final IRolRepository rolRepository;
    private final IRestaurantFeignClientRepository restaurantFeignClientRepository;
    private final IRestaurantEmployeeFeignClientRepository restaurantEmployeeFeignClientRepository;


    public UserServicePort(IUserRepository userRepository,
                           IToken token,
                           IUserPasswordEncoder userPasswordEncoder,
                           IRolRepository rolRepository,
                           IRestaurantFeignClientRepository restaurantFeignClientRepository,
                           IRestaurantEmployeeFeignClientRepository restaurantEmployeeFeignClientRepository) {
        this.userRepository = userRepository;
        this.token=token;
        this.userPasswordEncoder = userPasswordEncoder;
        this.rolRepository = rolRepository;
        this.restaurantFeignClientRepository = restaurantFeignClientRepository;
        this.restaurantEmployeeFeignClientRepository = restaurantEmployeeFeignClientRepository;
    }

    @Override
    public UserModel save(UserModel userModel) {
       validateRol(userModel);
       userModel.setPassword(userPasswordEncoder.encode(userModel.getPassword()));
       try{
          return userRepository.save(userModel);
       }catch (Exception e){
           throw new DomainException(e.getMessage());
       }
    }

    @Override
    public void saveEmployee(UserModel userModel) {
        UserModel userResult = save(userModel);
        if(userResult==null) throw new DomainException("The user could not be created");
        Long ownerAuth = token.getUserAuthenticationId(token.getBearerToken());

        RestaurantModel restaurantModel = restaurantFeignClientRepository.getRestaurantByOwner(ownerAuth);
        if(restaurantModel==null) throw new DomainException("Restaurant not found");

        RestaurantEmployeeModel restaurantEmployeeModel = new RestaurantEmployeeModel();
        restaurantEmployeeModel.setRestaurant(restaurantModel);
        restaurantEmployeeModel.setUserId(userResult.getId());
        restaurantEmployeeFeignClientRepository.saveRestaurantEmployee(restaurantEmployeeModel);
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
        if((bearerToken == null)) throw new DomainException("Invalid token.");

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
            throw new DomainException("Role not found.");
        }
        return rolModel.get();
    }
}
