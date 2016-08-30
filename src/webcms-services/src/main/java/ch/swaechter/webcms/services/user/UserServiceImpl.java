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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles all user interactions.
 *
 * @author Simon Wächter
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * User repository for the all user interactions.
     */
    private final UserRepository userrepository;

    /**
     * Constructor with the user repository.
     *
     * @param userrepository User repository
     */
    @Autowired
    public UserServiceImpl(UserRepository userrepository) {
        this.userrepository = userrepository;

        User user1 = new User();
        user1.setUsername("swaechter");
        user1.setDisplayName("Simon Wächter");
        user1.setPasswordHash("Secret");
        userrepository.save(user1);
    }

    /**
     * Get all users.
     *
     * @return All users.
     */
    public List<User> getUsers() {
        return userrepository.findAll();
    }
}
