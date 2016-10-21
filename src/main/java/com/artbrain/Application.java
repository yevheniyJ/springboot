package com.artbrain;

import com.artbrain.dao.UserDetailsServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableAutoConfiguration
public class Application extends WebMvcConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceDAO();
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/error").setViewName("error");
    registry.addViewController("/profile").setViewName("profile");
  }

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {
    return container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error"), new ErrorPage(HttpStatus.FORBIDDEN, "/error"));
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
