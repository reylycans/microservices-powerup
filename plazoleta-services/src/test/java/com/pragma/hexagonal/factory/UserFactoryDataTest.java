package com.pragma.hexagonal.factory;

import com.pragma.hexagonal.domain.model.RolModel;
import com.pragma.hexagonal.domain.model.UserModel;

public class UserFactoryDataTest {

    public static UserModel getUserOwner(){
        UserModel userModel = new UserModel();
        userModel.setName("owner");
        userModel.setPassword("owner");
        userModel.setLastName("de avila");
        userModel.setCellPhone("+5784765324");
        userModel.setIdentityDocument(1544837L);
        userModel.setEmail("owner-ricardo@hotmail.com");
        userModel.setRol(rolOwner());
        return userModel;
    }

    public static RolModel rolOwner(){
        RolModel rolModel = new RolModel();
        rolModel.setId(2L);
        rolModel.setName("OWNER");
        rolModel.setDescription("propietario de un restaurante");
        return rolModel;
    }
}
