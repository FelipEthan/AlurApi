package com.aluracuros.forohub.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {
    
   @Autowired
   private Security security;
  
   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {    
       return http.csrf().disable().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, "/login").permitAll()
            .requestMatchers("/swagger-ui.html", "/v3/api-docs/**","/swagger-ui/**").permitAll()
            // perfiles de acceso para los usuarios. 
            //.requestMatchers(HttpMethod.GET, "/medicos").hasRole("ADMIN")
            //.requestMatchers(HttpMethod.DELETE, "/pacientes").hasRole("ADMIN")      
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(security, UsernamePasswordAuthenticationFilter.class)
            .build();
       
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    

    
    
    @Bean
    public  PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
