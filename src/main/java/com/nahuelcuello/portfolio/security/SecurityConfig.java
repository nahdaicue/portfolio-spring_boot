package com.nahuelcuello.portfolio.security;

import com.nahuelcuello.portfolio.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final CorsConfigurationSource corsConfigurationSource;

    //Rule of endpoints
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest
                // públicos
                .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/portfolio").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/profile/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/projects").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/projects/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/email/**").permitAll()
                // solo ADMIN
                .requestMatchers(HttpMethod.POST, "/api/projects").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/projects/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/projects/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/profile/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/profile/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                ).sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
