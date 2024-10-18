package com.bnponlinebookstore.springboot.demo.bnponlinestore.entity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails oumar = User.builder()
                .username("oumar")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        UserDetails jean = User.builder()
                .username("jean")
                .password("{noop}password")
                .roles("CLIENT")
                .build();
        return new InMemoryUserDetailsManager(oumar, jean);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        // Allow CLIENT and ADMIN roles to access GET requests
                        .requestMatchers(HttpMethod.GET, "/api/books/**").hasAnyRole("CLIENT", "ADMIN")

                        // Only allow ADMIN role to access POST, PUT, DELETE requests
                        .requestMatchers(HttpMethod.POST, "/api/books").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/books/**").hasRole("ADMIN")
                );

        //use basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF
        http.csrf(csrf-> csrf.disable());
        return http.build();


    }
}
