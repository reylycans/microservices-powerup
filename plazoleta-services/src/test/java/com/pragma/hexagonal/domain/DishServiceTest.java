package com.pragma.hexagonal.domain;

import com.pragma.hexagonal.domain.exception.DishDomainException;
import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.port.out.IDishRepository;
import com.pragma.hexagonal.domain.port.out.IToken;
import com.pragma.hexagonal.domain.service.DishServicePort;
import com.pragma.hexagonal.factory.DishFactoryDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class DishServiceTest {

    @InjectMocks
    DishServicePort dishServicePort;
    @Mock
    IDishRepository dishRepository;
    @Mock
    IToken token;

    @Test
    public void save(){
        DishModel dishModel = DishFactoryDataTest.getDish();

        Mockito.when(token.getBearerToken()).thenReturn("validToken");
        Mockito.when(token.getUserAuthenticateId("validToken")).thenReturn(20L);

        dishServicePort.save(dishModel);
        Mockito.verify(dishRepository).save(dishModel);
    }

    @Test
    public void update(){
        DishModel dishModel = DishFactoryDataTest.getDish();

        Mockito.when(token.getBearerToken()).thenReturn("validToken");
        Mockito.when(token.getUserAuthenticateId("validToken")).thenReturn(20L);

        Mockito.when(dishRepository.getDishById(1L)).thenReturn(Optional.of(dishModel));

        dishServicePort.update(1L,dishModel);
        Mockito.verify(dishRepository).update(dishModel);
    }

    @Test
    public void dishUpdateEnableOrDisable(){
        DishModel dishModel = DishFactoryDataTest.getDish();

        Mockito.when(token.getBearerToken()).thenReturn("validToken");
        Mockito.when(token.getUserAuthenticateId("validToken")).thenReturn(20L);

        Mockito.when(dishRepository.getDishById(1L)).thenReturn(Optional.of(dishModel));

        dishServicePort.dishUpdateEnableOrDisable(1L,Boolean.TRUE);
        Mockito.verify(dishRepository).save(dishModel);
    }

    @Test
    public void dishUpdateEnableOrDisableError(){
        Mockito.when(token.getBearerToken()).thenReturn("validToken");
        Mockito.when(token.getUserAuthenticateId("validToken")).thenReturn(20L);

        Mockito.when(dishRepository.getDishById(2L)).thenReturn(Optional.empty());

        assertThrows(DishDomainException.class,
                ()->dishServicePort.dishUpdateEnableOrDisable(2L,Boolean.TRUE));

    }



}
