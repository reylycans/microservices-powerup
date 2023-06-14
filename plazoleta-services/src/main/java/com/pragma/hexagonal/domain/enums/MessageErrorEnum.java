package com.pragma.hexagonal.domain.enums;

public enum MessageErrorEnum {

    ORDER_SAVE("O-01","You cannot place another order because you already have and order in pending, ready o preparation status"),
    ORDER_RESTAURANT_EMPLOYE_NOT_EXIST("O-02","restaurant employee does not exist"),
    ORDER_NOT_FOUND("O-03","there is no existing order"),
    ORDER_STATUS_CANNOT_DIFFERENT("O-04","the status cannot be different from preparation"),
    ORDER_NO_FOUND_IN_PENDING_STATUS("O-05","no order found in pending status"),
    ORDER_EMPLOYEE_NOT_MATCH_RESTAURANT("O-06","the employee does not match the restaurant"),
    ORDER_INVALID_PIN("O'07","invalid pin"),
    ORDER_CANCELED_MESSAGE("O-08","Sorry, your order is already being prepared and cannot be canceled"),
    RESTAURANT_SAVE_OWNER_NOT_FOUND("R-01","Restaurant owner to create does not exist"),
    RESTAURANT_NOT_FOUND("R-02","Restaurant not found"),
    RESTAURANT_USER_MUST_BE_OWNER("R-03","User must be owner"),
    RESTAURANT_COULD_NOT_FIND_A_LIST("R-04"," Could not find a list of restaurants"),
    DISH_SAVE_ALREADY_EXIST("D-01","Dish already exist"),
    DISH_DOES_NOT_EXIST_TO_UPDATE("D-02","Dish does not exist to update"),
    DISH_UPDATE_ENABLE_OR_DISABLE("D-03","Could not enable or disable the dish because it does not exist"),
    CATEGORY_SAVE("C-01","Category already exist"),
    CATEGORY_NOT_FOUND("C-02","Category not found");



    private String value;
    private String message;

     MessageErrorEnum(String valor, String etiqueta) {
        this.value = valor;
        this.message = etiqueta;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return message;
    }
}
