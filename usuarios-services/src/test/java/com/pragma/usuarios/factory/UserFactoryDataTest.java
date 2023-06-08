package com.pragma.usuarios.factory;
import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.model.UserModel;


public class UserFactoryDataTest {

    public static UserModel getUser(){
        UserModel userModel = new UserModel();
        userModel.setName("manuel");
        userModel.setPassword("admin");
        userModel.setLastName("de avila");
        userModel.setCellPhone("+57847654");
        userModel.setIdentityDocument(1234837L);
        userModel.setEmail("mm-ricardo@hotmail.com");
        userModel.setRol(rolOwner());
        return userModel;
    }

    public static UserModel getUserEmployee(){
        UserModel userModel = new UserModel();
        userModel.setName("owner");
        userModel.setPassword("owner");
        userModel.setLastName("de avila");
        userModel.setCellPhone("+57847654");
        userModel.setIdentityDocument(1234837L);
        userModel.setEmail("employee-ricardo@hotmail.com");
        userModel.setRol(rolOwner());
        return userModel;
    }

    public static UserModel getUserCustomer(){
        UserModel userModel = new UserModel();
        userModel.setName("customer");
        userModel.setPassword("customer");
        userModel.setLastName("de avila");
        userModel.setCellPhone("+5784765324");
        userModel.setIdentityDocument(1544837L);
        userModel.setEmail("customer-ricardo@hotmail.com");
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
