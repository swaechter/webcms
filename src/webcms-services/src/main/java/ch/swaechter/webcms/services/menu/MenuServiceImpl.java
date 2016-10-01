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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles all menu interactions.
 *
 * @author Simon Wàchter
 */
@Service
public class MenuServiceImpl implements MenuService {

    /**
     * Menu repository for all menu interactions.
     */
    private final MenuRepository menurepository;

    /**
     * Constructor with the menu repository.
     *
     * @param menurepository Menu repository
     */
    @Autowired
    public MenuServiceImpl(MenuRepository menurepository) {
        this.menurepository = menurepository;

        Menu menu1 = new Menu();
        menu1.setName("Menu 1");
        menu1.setUrl("/page/1");
        menurepository.save(menu1);

        Menu menu2 = new Menu();
        menu2.setName("Menu 2");
        menu2.setUrl("/page/2");
        menurepository.save(menu2);

        Menu menu3 = new Menu();
        menu3.setName("Menu 3");
        menu3.setUrl("/page/3");
        menurepository.save(menu3);
    }

    /**
     * Get all menus.
     *
     * @return All menus
     */
    public List<Menu> getAllMenus() {
        return menurepository.findAll();
    }

    /**
     * Get an existing menu.
     *
     * @param id ID of the menu
     * @return Menu
     */
    public Menu getMenu(long id) {
        return menurepository.findOne(id);
    }

    /**
     * Check if a menu does exist.
     *
     * @param id ID of the menu
     * @return Status
     */
    public boolean isMenuExisting(long id) {
        return menurepository.exists(id);
    }

    /**
     * Create a new menu.
     *
     * @param menu New menu
     */
    public void createMenu(Menu menu) {
        menurepository.save(menu);
    }

    /**
     * Update an existing menu.
     *
     * @param menu Menu
     */
    public void updateMenu(Menu menu) {
        menurepository.save(menu);
    }

    /**
     * Delete an existing menu.
     *
     * @param id ID of the menu
     */
    public void deleteMenu(long id) {
        menurepository.delete(id);
    }
}
