package com.mock.flight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetaislService;

    @Autowired
    private AuthEntryPointJwt unauthorizeHandler;

    @Bean
    public AuthTokenFilter auththenticationJwtFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.parentAuthenticationManager(authenticationManagerBean())
                .userDetailsService(userDetaislService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetaislService);
//        provider.setPasswordEncoder(new BCryptPasswordEncoder());
//        return provider;
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic();
//        http.authorizeRequests().mvcMatchers("/api/auth/**").permitAll()
//                .mvcMatchers(HttpMethod.POST, "/api/test/**").permitAll()
//                .mvcMatchers(HttpMethod.PUT, "/users/").permitAll()
//                .mvcMatchers(HttpMethod.DELETE, "/users/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(unauthorizeHandler)
//                .and().csrf().disable();
//
//        http.addFilterBefore(auththenticationJwtFilter(), UsernamePasswordAuthenticationFilter.class);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizeHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/api/test/**").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizeHandler)
                .and().csrf().disable();

        http.addFilterBefore(auththenticationJwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
