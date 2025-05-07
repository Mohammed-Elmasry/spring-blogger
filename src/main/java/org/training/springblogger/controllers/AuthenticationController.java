package org.training.springblogger.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.training.springblogger.entities.User;
import org.training.springblogger.requests.UserRegistrationRequest;

@RestController
public class AuthenticationController {

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationRequest user) {
        return "";
    }
}
