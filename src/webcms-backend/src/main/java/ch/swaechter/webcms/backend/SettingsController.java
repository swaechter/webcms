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

import ch.swaechter.webcms.services.settings.Settings;
import ch.swaechter.webcms.services.settings.SettingsService;
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
 * Handles all settings interactions.
 *
 * @author Simon Wächter
 */
@RestController
@RequestMapping("/api")
public class SettingsController {

    /**
     * Settings service for all settings interactions.
     */
    private final SettingsService settingsservice;

    /**
     * Constructor with the settings service.
     *
     * @param settingsservice Settings service
     */
    @Autowired
    public SettingsController(SettingsService settingsservice) {
        this.settingsservice = settingsservice;
    }

    /**
     * Get all settings.
     *
     * @return All settings
     */
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public ResponseEntity<List<Settings>> getSettingss() {
        try {
            List<Settings> settings = settingsservice.getAllSettingss();
            if (settings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(settings, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Find a settings.
     *
     * @param id Settings ID
     * @return Settings
     */
    @RequestMapping(value = "/settings/{id}", method = RequestMethod.GET)
    public ResponseEntity<Settings> getSettings(@PathVariable("id") long id) {
        try {
            Settings settings = settingsservice.getSettings(id);
            if (settings == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(settings, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create a new settings.
     *
     * @param settings Settings
     * @return Empty response
     */
    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public ResponseEntity<Void> createSettings(@RequestBody Settings settings) {
        try {
            if (settingsservice.isSettingsExisting(settings.getId())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            settingsservice.createSettings(settings);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update an existing settings.
     *
     * @param id       Settings ID
     * @param settings Settings
     * @return New settings
     */
    @RequestMapping(value = "/settings/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Settings> updateSettings(@PathVariable("id") long id, @RequestBody Settings settings) {
        try {
            Settings currentsettings = settingsservice.getSettings(id);
            if (currentsettings == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentsettings.setName(settings.getName());
            settingsservice.updateSettings(currentsettings);
            return new ResponseEntity<>(currentsettings, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete an existing settings.
     *
     * @param id Settings ID
     * @return Empty respone
     */
    @RequestMapping(value = "/settings/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Settings> deleteSettings(@PathVariable("id") long id) {
        try {
            Settings settings = settingsservice.getSettings(id);
            if (settings == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            settingsservice.deleteSettings(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
