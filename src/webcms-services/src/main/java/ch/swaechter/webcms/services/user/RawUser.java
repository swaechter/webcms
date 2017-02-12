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

package ch.swaechter.webcms.services.user;

/**
 * Represents the user entity for the login process.
 *
 * @author Simon Wächter
 */
public class RawUser {

    /**
     * Username of the user.
     */
    private String username;

    /**
     * Password of the user.
     */
    private String password;

    /**
     * Default constructor.
     */
    public RawUser() {
    }

    /**
     * Get the user username.
     *
     * @return User username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the new user username.
     *
     * @param username User username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user password.
     *
     * @return User password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the new user password.
     *
     * @param password User password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
