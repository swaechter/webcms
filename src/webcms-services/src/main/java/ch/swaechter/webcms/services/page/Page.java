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

package ch.swaechter.webcms.services.page;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents the page identity.
 *
 * @author Simon Wächter
 */
@Entity
@Table(name = "pages")
public class Page {

    /**
     * ID of the page.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * Title of the page.
     */
    private String title;

    /**
     * Content of the page.
     */
    private String content;

    /**
     * Default constructor.
     */
    public Page() {
    }

    /**
     * Get the page ID.
     *
     * @return Page ID
     */
    public long getId() {
        return id;
    }

    /**
     * Set the new page ID.
     *
     * @param id New page ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the page title.
     *
     * @return Page title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the new page title.
     *
     * @param title New page title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the page content.
     *
     * @return Page content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the new page content.
     *
     * @param content New page content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
