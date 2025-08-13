package com.hust.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "User firstName must be not empty")
    private String firstName;

    @NotEmpty(message = "User lastName must be not empty")
    private String lastName;

    @NotEmpty(message =  "User email must be not empty")
    @Email(message = "User email must be valid")
    private String email;
}
