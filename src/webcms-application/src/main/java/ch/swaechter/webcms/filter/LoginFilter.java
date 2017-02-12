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

package ch.swaechter.webcms.filter;

import ch.swaechter.webcms.core.properties.Properties;
import ch.swaechter.webcms.services.user.RawUser;
import ch.swaechter.webcms.utils.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class is responsible for checking the incoming login request. If the login is valid, a user authentication will be created.
 *
 * @author Simon Wächter
 */
public class LoginFilter extends AbstractAuthenticationProcessingFilter {

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
    public LoginFilter(String url, AuthenticationManager authenticationManager, Properties properties) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
        this.properties = properties;
    }

    /**
     * Try to serialize the user login and authenticate it.
     *
     * @param request  Incoming request
     * @param response Outgoing response
     * @return Authentication of the user
     * @throws AuthenticationException Authentication exception in case of an invalid login
     * @throws IOException             Exception in case of an internal problem
     * @throws ServletException        Exception in case of an internal problem
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        RawUser user = new ObjectMapper().readValue(request.getInputStream(), RawUser.class);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        return getAuthenticationManager().authenticate(token);
    }

    /**
     * If the login was successful, add an access token to header of the response.
     *
     * @param request        Incoming request
     * @param response       Outgoing response
     * @param chain          Filter
     * @param authentication Valid authentication of the user
     * @throws IOException      Exception in case of an internal problem
     * @throws ServletException Exception in case of an internal problem
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        String token = TokenUtils.encodeToken(authentication.getName(), properties.getSecuritySecret());
        response.addHeader(TokenUtils.HEADER_KEY, token);
    }
}
