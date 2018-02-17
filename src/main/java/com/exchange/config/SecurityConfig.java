package com.exchange.config;

import com.exchange.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Lenovo on 03.02.2018.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.exchange")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/exchange/**").permitAll()
                .antMatchers("/exchange/loginpage").permitAll()
                .antMatchers("/user/add").permitAll()
                .antMatchers("/cantor/**").permitAll()
                .antMatchers("/exchange/main").authenticated()
                .and()
                .formLogin()
                    .loginPage("/exchange/loginPage").permitAll()
                    .loginProcessingUrl("/exchange/processlogin").permitAll()
                    .failureUrl("/exchange/loginError")
                .usernameParameter("login")
                .passwordParameter("password")
                    .defaultSuccessUrl("/exchange/main")
                .and()
                .logout()
                .logoutUrl("/logoutuser").permitAll()
                .logoutSuccessUrl("/exchange/loginPage").permitAll();
    }

}
