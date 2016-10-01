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

import java.util.List;

/**
 * Handle all page interactions.
 *
 * @author Simon Wächter
 */
public interface PageService {

    /**
     * Get all pages.
     *
     * @return All pages
     */
    List<Page> getAllPages();

    /**
     * Get an existing page.
     *
     * @param id ID of the page
     * @return Page
     */
    Page getPage(long id);

    /**
     * Check if a page does exist.
     *
     * @param id ID of the page
     * @return Status
     */
    boolean isPageExisting(long id);

    /**
     * Create a new page.
     *
     * @param page New page
     */
    void createPage(Page page);

    /**
     * Update an existing page.
     *
     * @param page Page
     */
    void updatePage(Page page);

    /**
     * Delete an existing page.
     *
     * @param id ID of the page
     */
    void deletePage(long id);
}
