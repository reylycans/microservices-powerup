package com.pragma.usuarios.domain;

import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.domain.port.out.IRolRepository;
import com.pragma.usuarios.domain.port.out.IUserRepository;
import com.pragma.usuarios.domain.port.out.authentication.IToken;
import com.pragma.usuarios.domain.port.out.authentication.IUserPasswordEncoder;
import com.pragma.usuarios.domain.usercase.UserServicePort;
import com.pragma.usuarios.factory.UserFactoryDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class UserCaseTest {

    @InjectMocks
    UserServicePort userServicePort;
    @Mock
    IUserRepository userRepository;
    @Mock
    IRolRepository rolRepository;
    @Mock
    IToken token;
    @Mock
    IUserPasswordEncoder passwordEncoder;


    @Test
    void saveUserOwner(){
        UserModel userModel = UserFactoryDataTest.getUser();
        RolModel rolModel = UserFactoryDataTest.rolOwner();
        Mockito.when(token.getBearerToken()).thenReturn("Bearer token");
        Mockito.when(token.getUserAuthenticationRol("Bearer token")).thenReturn("ADMIN");
        Mockito.when(passwordEncoder.encode(Mockito.any())).thenReturn("encodedPassword#gfdg23232");

        Mockito.when(rolRepository.findById(2L)).thenReturn(Optional.of(rolModel));

        userServicePort.save(userModel);

        Mockito.verify(passwordEncoder).encode("admin");
        Mockito.verify(userRepository).save(Mockito.any(UserModel.class));
    }

    @Test
    void saveUserEmployee(){
        UserModel userModel = UserFactoryDataTest.getUserEmployee();
        RolModel rolModel = UserFactoryDataTest.rolOwner();
        Mockito.when(token.getBearerToken()).thenReturn("Bearer token");
        Mockito.when(token.getUserAuthenticationRol("Bearer token")).thenReturn("OWNER");
        Mockito.when(passwordEncoder.encode(Mockito.any())).thenReturn("encodedPassword#g7hhjt7");

        Mockito.when(rolRepository.findById(3L)).thenReturn(Optional.of(rolModel));

        userServicePort.save(userModel);

        Mockito.verify(passwordEncoder).encode("owner");
        Mockito.verify(userRepository).save(Mockito.any(UserModel.class));
    }

    @Test
    void saveUserCustomer(){
        UserModel userModel = UserFactoryDataTest.getUserCustomer();
        RolModel rolModel = UserFactoryDataTest.rolOwner();
        Mockito.when(token.getBearerToken()).thenReturn("Bearer token");
        Mockito.when(token.getUserAuthenticationRol("Bearer token")).thenReturn("CUSTOMER");
        Mockito.when(passwordEncoder.encode(Mockito.any())).thenReturn("encodedPassword#kdhf76");

        Mockito.when(rolRepository.findById(4L)).thenReturn(Optional.of(rolModel));

        userServicePort.save(userModel);

        Mockito.verify(passwordEncoder).encode("customer");
        Mockito.verify(userRepository).save(Mockito.any(UserModel.class));
    }


}
