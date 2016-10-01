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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Handles all page requests.
 *
 * @author Simon Wächter
 */
@RestController
@RequestMapping("/api")
public class PageController {

    /**
     * Page service for all page interactions.
     */
    private final PageService pageservice;

    /**
     * Constructor with the page service.
     *
     * @param pageservice Page service
     */
    @Autowired
    public PageController(PageService pageservice) {
        this.pageservice = pageservice;
    }

    /**
     * Get all pages.
     *
     * @return All pages
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<List<Page>> getPages() {
        try {
            List<Page> pages = pageservice.getAllPages();
            if (pages.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pages, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Find a page.
     *
     * @param id Page ID
     * @return Page
     */
    @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
    public ResponseEntity<Page> getPage(@PathVariable("id") long id) {
        try {
            Page page = pageservice.getPage(id);
            if (page == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(page, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create a new page.
     *
     * @param page Page
     * @return Empty response
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResponseEntity<Void> createPage(@RequestBody Page page) {
        try {
            if (pageservice.isPageExisting(page.getId())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            pageservice.createPage(page);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update an existing page.
     *
     * @param id   Page ID
     * @param page Page
     * @return New page
     */
    @RequestMapping(value = "/page/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Page> updatePage(@PathVariable("id") long id, @RequestBody Page page) {
        try {
            Page currentpage = pageservice.getPage(id);
            if (currentpage == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentpage.setTitle(page.getTitle());
            currentpage.setContent(page.getContent());
            pageservice.updatePage(currentpage);
            return new ResponseEntity<>(currentpage, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete an existing page.
     *
     * @param id Page ID
     * @return Empty respone
     */
    @RequestMapping(value = "/page/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Page> deletePage(@PathVariable("id") long id) {
        try {
            Page page = pageservice.getPage(id);
            if (page == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            pageservice.deletePage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
