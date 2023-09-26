package com.example.animeWorld.control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration

public class configurazioneSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	 
        http.authorizeHttpRequests(
                auth -> auth.requestMatchers("/register/**").permitAll()
                
                .requestMatchers("/private/**").authenticated()
               
               // .requestMatchers("/users/**", "/apps/**").hasAuthority("ADMIN")
                .anyRequest().permitAll()
               )
                .formLogin(formLogin -> formLogin
                       // .loginPage("/login")
                       // .usernameParameter("email")
                    //    .defaultSuccessUrl("/", true)
                        .permitAll()
                )
        
               // .rememberMe(rememberMe -> rememberMe.key("AbcdEfghIjkl..."))
                .logout(logout -> logout.logoutUrl("/logout").permitAll());
     
     
        return http.build();
    }
    
    
}
