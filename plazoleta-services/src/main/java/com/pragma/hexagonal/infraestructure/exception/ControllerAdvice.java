package com.pragma.hexagonal.infraestructure.exception;

import com.pragma.hexagonal.domain.enums.MessageErrorEnum;
import com.pragma.hexagonal.domain.exception.CategoryDomainException;
import com.pragma.hexagonal.domain.exception.DishDomainException;
import com.pragma.hexagonal.domain.exception.OrderDomainException;
import com.pragma.hexagonal.domain.exception.RestaurantDomainException;
import com.pragma.hexagonal.infraestructure.exception.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

   @ExceptionHandler(value = OrderDomainException.class)
   public ResponseEntity<ErrorDto> OrderExceptionHandler(OrderDomainException orderDomainException){
       ErrorDto errorDto = ErrorDto.builder().code(orderDomainException.getCode()).message(getMessageError(orderDomainException.getCode())).build();
       return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
   }

    @ExceptionHandler(value = RestaurantDomainException.class)
    public ResponseEntity<ErrorDto> RestaurantExceptionHandler(RestaurantDomainException restaurantDomainException){
        ErrorDto errorDto = ErrorDto.builder().code(restaurantDomainException.getCode()).message(getMessageError(restaurantDomainException.getCode())).build();
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DishDomainException.class)
    public ResponseEntity<ErrorDto> DishExceptionHandler(DishDomainException dishDomainException){
        ErrorDto errorDto = ErrorDto.builder().code(dishDomainException.getCode()).message(getMessageError(dishDomainException.getCode())).build();
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CategoryDomainException.class)
    public ResponseEntity<ErrorDto> CategoryExceptionHandler(CategoryDomainException categoryDomainException){
        ErrorDto errorDto = ErrorDto.builder().code(categoryDomainException.getCode()).message(getMessageError(categoryDomainException.getCode())).build();
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }


   private String getMessageError(String code){
       switch (code){
           case "O-01":
               return MessageErrorEnum.ORDER_SAVE.getMessage();
           case "O-02":
               return MessageErrorEnum.ORDER_RESTAURANT_EMPLOYE_NOT_EXIST.getMessage();
           case "O-03":
               return MessageErrorEnum.ORDER_NOT_FOUND.getMessage();
           case "O-04":
               return MessageErrorEnum.ORDER_STATUS_CANNOT_DIFFERENT.getMessage();
           case "O-05":
               return MessageErrorEnum.ORDER_NO_FOUND_IN_PENDING_STATUS.getMessage();
           case "O-06":
               return MessageErrorEnum.ORDER_EMPLOYEE_NOT_MATCH_RESTAURANT.getMessage();
           case "O-07":
               return MessageErrorEnum.ORDER_INVALID_PIN.getMessage();
           case "O-'8":
               return MessageErrorEnum.ORDER_CANCELED_MESSAGE.getMessage();
           case "R-01":
               return MessageErrorEnum.RESTAURANT_SAVE_OWNER_NOT_FOUND.getMessage();
           case "R-02":
               return MessageErrorEnum.RESTAURANT_NOT_FOUND.getMessage();
           case "R-03":
               return MessageErrorEnum.RESTAURANT_USER_MUST_BE_OWNER.getMessage();
           case "R-04":
               return MessageErrorEnum.RESTAURANT_COULD_NOT_FIND_A_LIST.getMessage();
           case "D-01":
               return MessageErrorEnum.DISH_SAVE_ALREADY_EXIST.getMessage();
           case "D-02":
               return MessageErrorEnum.DISH_DOES_NOT_EXIST_TO_UPDATE.getMessage();
           case "D-03":
               return MessageErrorEnum.DISH_UPDATE_ENABLE_OR_DISABLE.getMessage();
           case "C-01":
               return MessageErrorEnum.CATEGORY_SAVE.getMessage();
           case "C-02":
               return MessageErrorEnum.CATEGORY_NOT_FOUND.getMessage();
           default:
               return HttpStatus.INTERNAL_SERVER_ERROR.toString();
       }
   }
}
