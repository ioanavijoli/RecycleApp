package com.example.demo.configuration;

import com.example.demo.security.AuthEntryPointJwt;
import com.example.demo.security.AuthTokenFilter;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;
    @Autowired
    UserServiceImpl userDetailsService;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/user").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/user/signup").permitAll()
                .antMatchers("/user/find/**").permitAll()
                .antMatchers("/user/update").permitAll()
                .antMatchers("/recyclingCenter/find/**").permitAll()
                .antMatchers("/recyclingCenter/insertCenter").permitAll()
                .antMatchers("/recyclingCenter/recieveFeedback").permitAll()
                .antMatchers("/recyclingCenter/getFeedback").permitAll()
                .antMatchers("/recyclingCenter/deleteCenter").permitAll()
                .antMatchers("/recyclingCenter/update").permitAll()
                .antMatchers("/product/insertProduct").permitAll()
                .antMatchers("/product/find/**").permitAll()
                .antMatchers("/product/deleteProduct").permitAll()
                .antMatchers("/product/update").permitAll()
                .antMatchers("/product/getByCategoryId").permitAll()
                .antMatchers("/category/insertCategory").permitAll()
                .antMatchers("/category/find/**").permitAll()
                .antMatchers("/category/delete").permitAll()
                .antMatchers("/category/update").permitAll()
                .antMatchers("/category/getCategoriesByCenterId").permitAll()
                .antMatchers("/appointment/getAppointments").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}