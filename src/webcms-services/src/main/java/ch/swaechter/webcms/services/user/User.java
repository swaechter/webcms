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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents the user entity.
 *
 * @author Simon Wächter
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * ID of the user.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * Username of the user.
     */
    private String username;

    /**
     * Displayable name of the user.
     */
    private String displayname;

    /**
     * Password hash of the user.
     */
    private String passwordhash;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Get the user ID.
     *
     * @return User ID
     */
    public long getId() {
        return id;
    }

    /**
     * Set the new user ID.
     *
     * @param id User ID
     */
    public void setId(long id) {
        this.id = id;
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
     * Get the user display name.
     *
     * @return User display name
     */
    public String getDisplayName() {
        return displayname;
    }

    /**
     * Set the new user display name.
     *
     * @param displayname User display name
     */
    public void setDisplayName(String displayname) {
        this.displayname = displayname;
    }

    /**
     * Get the user password hash.
     *
     * @return User password hash
     */
    public String getPasswordHash() {
        return passwordhash;
    }

    /**
     * Set the new user password hash.
     *
     * @param passwordhash User password hash
     */
    public void setPasswordHash(String passwordhash) {
        this.passwordhash = passwordhash;
    }
}
