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
import ch.swaechter.webcms.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * This class is responsible for checking all incoming requests and accept or reject them based on the access token.
 *
 * @author Simon Wächter
 */
public class AuthenticationFilter extends GenericFilterBean {

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
    public AuthenticationFilter(Properties properties) {
        this.properties = properties;
    }

    /**
     * Check the incoming request. If the access token is parsable, a user authentication will be created.
     *
     * @param request  Incoming request
     * @param response Outgoing response
     * @param chain    Filter chain
     * @throws IOException      Exception in case of an internal problem
     * @throws ServletException Exception in case of an internal problem
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) request;
        Optional<String> username = TokenUtils.decodeToken(httprequest.getHeader(TokenUtils.HEADER_KEY), properties.getSecuritySecret());
        if (username.isPresent()) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username.get(), null, null);
            SecurityContextHolder.getContext().setAuthentication(token);
            chain.doFilter(request, response);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
            chain.doFilter(request, response);
        }
    }
}
