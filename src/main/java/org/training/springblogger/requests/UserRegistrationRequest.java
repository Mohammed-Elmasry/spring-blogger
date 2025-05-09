package org.training.springblogger.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.training.springblogger.validationConstraints.constraints.MatchField;

@Data
@MatchField(field = "password", fieldMatcher = "confirmPassword", message = "Password does not match the confirmPassword")
public class UserRegistrationRequest {

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 48)
    private String password;

    @NotBlank
    private String confirmPassword;
}
