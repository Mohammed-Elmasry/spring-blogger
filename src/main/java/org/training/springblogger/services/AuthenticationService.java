package org.training.springblogger.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.springblogger.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;




}
