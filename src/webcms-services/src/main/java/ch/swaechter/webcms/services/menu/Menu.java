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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents the menu entity.
 *
 * @author Simon Wächter
 */
@Entity
@Table(name = "menus")
public class Menu {

    /**
     * ID of the menu.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * Name of the menu.
     */
    private String name;

    /**
     * URL of the page.
     */
    private String url;

    /**
     * Default constructor.
     */
    public Menu() {
    }

    /**
     * Get the menu ID.
     *
     * @return Menu ID
     */
    public long getId() {
        return id;
    }

    /**
     * Set the new menu ID.
     *
     * @param id New menu ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the menu name.
     *
     * @return Menu name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the new menu name.
     *
     * @param name New menu name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the page URL.
     *
     * @return Page URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the new page URL.
     *
     * @param url New page URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
