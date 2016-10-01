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

import java.util.List;

/**
 * Handles all user interactions.
 *
 * @author Simon Wächter
 */
public interface UserService {

    /**
     * Get all users.
     *
     * @return All users
     */
    List<User> getAllUsers();

    /**
     * Get an existing user.
     *
     * @param id ID of the user
     * @return User
     */
    User getUser(long id);

    /**
     * Check if a user does exist.
     *
     * @param id ID of the user
     * @return Status
     */
    boolean isUserExisting(long id);

    /**
     * Create a new user.
     *
     * @param user New user
     */
    void createUser(User user);

    /**
     * Update an existing user.
     *
     * @param user User
     */
    void updateUser(User user);

    /**
     * Delete an existing user.
     *
     * @param id ID of the user
     */
    void deleteUser(long id);
}
