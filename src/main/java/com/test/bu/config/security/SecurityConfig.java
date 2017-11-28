package com.test.bu.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT username, password FROM user WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role FROM user WHERE username = ?")
                .dataSource(dataSource);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
        //        .antMatchers("/**").hasRole("USER")
        //        .antMatchers("/**").hasRole("ADMIN")
        //        .antMatchers("/**/all").hasRole("USER")
        //        .antMatchers("/**/all").hasRole("ADMIN")
        //        .antMatchers("/**/**").hasRole("ADMIN")
                .and().formLogin()
                .loginPage("/loginPage").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/errorPage");
    }
}
