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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles all page interactions.
 */
@Service
public class PageServiceImpl implements PageService {

    /**
     * Page repository for all page interactions.
     */
    private final PageRepository pagerepository;

    /**
     * Constructor with the page repository.
     *
     * @param pagerepository Page repository
     */
    @Autowired
    public PageServiceImpl(PageRepository pagerepository) {
        this.pagerepository = pagerepository;

        Page page1 = new Page();
        page1.setTitle("Page 1");
        page1.setContent("Page content 1");
        pagerepository.save(page1);

        Page page2 = new Page();
        page2.setTitle("Page 2");
        page2.setContent("Page content 2");
        pagerepository.save(page2);

        Page page3 = new Page();
        page3.setTitle("Page 3");
        page3.setContent("Page content 3");
        pagerepository.save(page3);
    }

    /**
     * Get all pages.
     *
     * @return All pages
     */
    public List<Page> getAllPages() {
        return pagerepository.findAll();
    }

    /**
     * Get an existing page.
     *
     * @param id ID of the page
     * @return Page
     */
    public Page getPage(long id) {
        return pagerepository.findOne(id);
    }

    /**
     * Check if a page does exist.
     *
     * @param id ID of the page
     * @return Status
     */
    public boolean isPageExisting(long id) {
        return pagerepository.exists(id);
    }

    /**
     * Create a new page.
     *
     * @param page New page
     */
    public void createPage(Page page) {
        pagerepository.save(page);
    }

    /**
     * Update an existing page.
     *
     * @param page Page
     */
    public void updatePage(Page page) {
        pagerepository.save(page);
    }

    /**
     * Delete an existing page.
     *
     * @param id ID of the page
     */
    public void deletePage(long id) {
        pagerepository.delete(id);
    }
}
