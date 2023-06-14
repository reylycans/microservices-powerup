package com.message.twilio.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MessageRequestDto {
    @NotBlank(message = "number is required")
    @Pattern(regexp = "^\\+57\\d{10}$", message = "The number must start with +57 followed by 10 digits (Colombian number)")
    private String number;

    @NotBlank(message = "menssage is required")
    private String message;
}
