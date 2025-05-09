package org.training.springblogger.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.training.springblogger.requests.UserRegistrationRequest;

@RestController
public class AuthenticationController {

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationRequest> register(@Valid @RequestBody UserRegistrationRequest user, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok().body(user);
    }
}
