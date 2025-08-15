package com.hust.usermanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Schema(
            description = "UserDto Id"
    )
    private Long id;

    @Schema(
            description = "UserDto First Name"
    )
    @NotEmpty(message = "User firstName must be not empty")
    private String firstName;

    @Schema(
            description = "UserDto Last Name"
    )
    @NotEmpty(message = "User lastName must be not empty")
    private String lastName;

    @Schema(
            description = "UserDto Email"
    )
    @NotEmpty(message =  "User email must be not empty")
    @Email(message = "User email must be valid")
    private String email;
}
