package com.artbrain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http
          .authorizeRequests()
            //static resources configuration
            .antMatchers("/resources/**", "/webjars/**", "/img/**").permitAll()
            //login page and registration end-point
            .antMatchers("/login", "/registration").permitAll()
            //all other requests
            .anyRequest().authenticated()
            .and()
          // login form configuration
          .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .defaultSuccessUrl("/", true)
            .permitAll()
            .and()
          //logout configuration
          .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //not secured, just for test application
    auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
  }

}
