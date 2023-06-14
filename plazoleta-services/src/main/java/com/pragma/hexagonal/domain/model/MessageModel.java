package com.pragma.hexagonal.domain.model;

public class MessageModel {
    private String number;
    private String message;

    private MessageModel(Builder builder) {
        setNumber(builder.number);
        setMessage(builder.message);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String number;
        private String message;

        private Builder() {
        }



        public Builder number(String val) {
            number = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public MessageModel build() {
            return new MessageModel(this);
        }
    }
}
