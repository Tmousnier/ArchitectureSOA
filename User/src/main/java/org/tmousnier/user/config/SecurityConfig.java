package org.tmousnier.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Pour tests locaux ; à configurer en prod
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/user/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }
}
