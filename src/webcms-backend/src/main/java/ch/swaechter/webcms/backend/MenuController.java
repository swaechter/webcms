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

package ch.swaechter.webcms.backend;

import ch.swaechter.webcms.services.menu.Menu;
import ch.swaechter.webcms.services.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Handles all menu requests.
 *
 * @author Simon Wächter
 */
@RestController
@RequestMapping("/api")
public class MenuController {

    /**
     * Menu service for all menu interactions.
     */
    private final MenuService menuservice;

    /**
     * Constructor with the menu service.
     *
     * @param menuservice Menu service
     */
    @Autowired
    public MenuController(MenuService menuservice) {
        this.menuservice = menuservice;
    }

    /**
     * Get all menus.
     *
     * @return All menus
     */
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> getMenus() {
        try {
            List<Menu> menus = menuservice.getAllMenus();
            return new ResponseEntity<>(menus, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Find a menu.
     *
     * @param id Menu ID
     * @return Menu
     */
    @GetMapping("/menu/{id}")
    public ResponseEntity<Menu> getMenu(@PathVariable("id") long id) {
        try {
            Menu menu = menuservice.getMenu(id);
            if (menu == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create a new menu.
     *
     * @param menu Menu
     * @return Empty response
     */
    @PostMapping("/menu")
    public ResponseEntity<Void> createMenu(@RequestBody Menu menu) {
        try {
            if (menuservice.isMenuExisting(menu.getId())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            menuservice.createMenu(menu);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update an existing menu.
     *
     * @param id   Menu ID
     * @param menu Menu
     * @return New menu
     */
    @PutMapping("/menu/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") long id, @RequestBody Menu menu) {
        try {
            Menu currentmenu = menuservice.getMenu(id);
            if (currentmenu == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentmenu.setName(menu.getName());
            currentmenu.setUrl(menu.getUrl());
            menuservice.updateMenu(currentmenu);
            return new ResponseEntity<>(currentmenu, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete an existing menu.
     *
     * @param id Menu ID
     * @return Empty respone
     */
    @DeleteMapping("/menu/{id}")
    public ResponseEntity<Menu> deleteMenu(@PathVariable("id") long id) {
        try {
            Menu menu = menuservice.getMenu(id);
            if (menu == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            menuservice.deleteMenu(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
