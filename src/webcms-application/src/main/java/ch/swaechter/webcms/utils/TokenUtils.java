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

package ch.swaechter.webcms.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Optional;

/**
 * This class is responsible for encoding and decoding access tokens.
 *
 * @author Simon Wächter
 */
public class TokenUtils {

    /**
     * HTTP header name for the token.
     */
    public static final String HEADER_KEY = "Authorization";

    /**
     * HTTP key suffix for the token.
     */
    public static final String HEADER_VALUE = "Bearer ";

    /**
     * Duration of the token.
     */
    private static final long TOKEN_DURATION = 1000 * 60 * 60 * 24 * 10;

    /**
     * Encode a token.
     *
     * @param subject Subject of the token
     * @param secret  Secret of the token
     * @return Valid token
     */
    public static String encodeToken(String subject, String secret) {
        Date date = new Date(System.currentTimeMillis() + TOKEN_DURATION);
        String token = Jwts.builder().setSubject(subject).setExpiration(date).signWith(SignatureAlgorithm.HS512, secret).compact();
        return HEADER_VALUE + token;
    }

    /**
     * Decode a token.
     *
     * @param token  Token
     * @param secret Secret of the token
     * @return Subject of the token
     */
    public static Optional<String> decodeToken(String token, String secret) {
        if (token == null || !token.startsWith(HEADER_VALUE)) {
            return Optional.empty();
        }

        token = token.replace(HEADER_VALUE, new String());

        if (token.length() == 0) {
            return Optional.empty();
        }

        try {
            String subject = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
            return Optional.of(subject);
        } catch (Exception exception) {
            return Optional.empty();
        }
    }
}
