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

import ch.swaechter.webcms.services.page.Page;
import ch.swaechter.webcms.services.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Handles all page requests.
 *
 * @author Simon Wächter
 */
@RestController
public class PageController {

    /**
     * Page service for all page interactions.
     */
    @Autowired
    private PageService pageservice;

    /**
     * Get all pages.
     *
     * @return All pages
     */
    @RequestMapping(value = "/api/pages/get")
    public List<Page> getPages() {
        return pageservice.getPages();
    }
}
