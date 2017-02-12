/*
 * WebCMS - A content management system (CMS) based on Spring and Angular.
 * Copyright (C) 2016 Simon Wächter (waechter.simon@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/
 */

package ch.swaechter.webcms.security;

import ch.swaechter.webcms.core.properties.Properties;
import ch.swaechter.webcms.filter.AuthenticationFilter;
import ch.swaechter.webcms.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * This class is responsible for managing the application access.
 *
 * @author Simon Wächter
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Properties with the application configuration.
     */
    private final Properties properties;

    /**
     * Constructor with the application configuration.
     *
     * @param properties Application configuration
     */
    @Autowired
    public SecurityConfiguration(Properties properties) {
        this.properties = properties;
    }

    /**
     * Application configuration that makes the frontend accessible and protects the backend through a JWT token system.
     *
     * @param security Security configuration
     * @throws Exception Exception in case of an internal problem
     */
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        // Control the cache and prevent malicious cache reuse
        security.headers().cacheControl();

        // Disable CSRF protection because we use a JWT based token authentication
        security.csrf().disable();

        // Allow access to the frontend/login and authenticate all other requests
        security.authorizeRequests().antMatchers("/", "/login", "/**.gz", "/**.js", "/**.css", "/**.ico").permitAll().anyRequest().authenticated();

        // Install a login and authentication filter to work with the JWT token
        security.addFilterBefore(new LoginFilter("/login", authenticationManager(), properties), UsernamePasswordAuthenticationFilter.class);
        security.addFilterBefore(new AuthenticationFilter(properties), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Provide an authentication manager for checking the users.
     *
     * @param builder Authentication manager builder
     * @throws Exception Exception in case of an internal problem
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }
}
