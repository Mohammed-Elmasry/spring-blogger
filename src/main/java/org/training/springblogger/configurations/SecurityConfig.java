package org.training.springblogger.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(
                auth -> auth.requestMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated());
        return httpSecurity.build();
    }


}
