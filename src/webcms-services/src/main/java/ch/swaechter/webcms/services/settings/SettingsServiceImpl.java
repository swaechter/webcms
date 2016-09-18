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

package ch.swaechter.webcms.services.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles all settings interactions.
 *
 * @author Simon Wächter
 */
@Service
public class SettingsServiceImpl implements SettingsService {

    /**
     * Settings repository for all settings interactions.
     */
    private final SettingsRepository settingsrepository;

    /**
     * Constructor with the settings repository.
     *
     * @param settingsrepository Settings repository
     */
    @Autowired
    public SettingsServiceImpl(SettingsRepository settingsrepository) {
        this.settingsrepository = settingsrepository;

        Settings settings1 = new Settings();
        settings1.setName("Defaultconfiguration");
        settingsrepository.save(settings1);
    }

    /**
     * Get all settings.
     *
     * @return All settings
     */
    public List<Settings> getSettings() {
        return settingsrepository.findAll();
    }
}