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

package ch.swaechter.webcms.services.menu;

import java.util.List;

/**
 * Handles all menu interactions.
 *
 * @author Simon Wàchter
 */
public interface MenuService {

    /**
     * Get all menus.
     *
     * @return All menus
     */
    List<Menu> getAllMenus();

    /**
     * Get an existing menu.
     *
     * @param id ID of the menu
     * @return Menu
     */
    Menu getMenu(long id);

    /**
     * Check if a menu does exist.
     *
     * @param id ID of the menu
     * @return Status
     */
    boolean isMenuExisting(long id);

    /**
     * Create a new menu.
     *
     * @param menu New menu
     */
    void createMenu(Menu menu);

    /**
     * Update an existing menu.
     *
     * @param menu Menu
     */
    void updateMenu(Menu menu);

    /**
     * Delete an existing menu.
     *
     * @param id ID of the menu
     */
    void deleteMenu(long id);
}
