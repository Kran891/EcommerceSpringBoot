package com.kran.commerce.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public JdbcUserDetailsManager ConfiguUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userManager=new JdbcUserDetailsManager(dataSource);
        userManager.setUsersByUsernameQuery("SELECT id,name,password from users where id=?");
        userManager.setAuthoritiesByUsernameQuery("SELECT user_id,role from roles where user_id=?");
        return userManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer->{
          configurer
          .requestMatchers(HttpMethod.POST,"/api/products").hasAnyRole("ADMIN","SELLER");
        });
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf->csrf.disable());
        return httpSecurity.build();
    }
}
