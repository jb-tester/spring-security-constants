package com.mytests.spring.springsecurityconstants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String[] SOME_PATHS = {"/test1","/test2"};
    public static final String SOME_PATH = "/test3";
    public static final String SOME_ROLE = "ADMIN";
    public static final String COMPOSED_AUTHORITY = "ROLE_" + SOME_ROLE;
    private static final String[] SOME_AUTHORITIES = {"ROLE_USER", "ROLE_ADMIN"};


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/test0").permitAll() // ok
                        .requestMatchers(SOME_PATHS).hasRole("USER") // not detected
                        .requestMatchers(SOME_PATH).hasRole(SOME_ROLE) // ok
                        .requestMatchers("/test4").hasAuthority(COMPOSED_AUTHORITY) // ok
                        .requestMatchers("/test5").hasAnyAuthority(SOME_AUTHORITIES) // not detected
                        .anyRequest().authenticated()
                )
                .formLogin((
                        form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
