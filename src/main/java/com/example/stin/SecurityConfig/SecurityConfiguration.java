package com.example.stin.SecurityConfig;

import com.example.stin.Users.UserDetails.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


/*
    * This class is used to create a security configuration
 */
@Configuration
public class SecurityConfiguration {

    /*
        * This method is used to create a user details service
        * @return UserDetailsService - the user details service
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

    /*
        * This method is used to create an authentication provider
        * @return DaoAuthenticationProvider - the authentication provider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    /*
        * This method is used to create an authentication manager
        * @param AuthenticationConfiguration auth - the authentication configuration
        * @return AuthenticationManager - the authentication manager
        * @throws Exception - the exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    /*
        * This method is used to create a security filter chain
        * @param HttpSecurity http - the http security
        * @return SecurityFilterChain - the security filter chain
        * @throws Exception - the exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/login", "/", "/verification", "/button", "/json", "/logout").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .addLogoutHandler(new SecurityContextLogoutHandler())
                );
        http.authenticationProvider(authenticationProvider());
        return http.build();
    }

    /*
        * This method is used to create a password encoder
        * @return BCryptPasswordEncoder - the password encoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

