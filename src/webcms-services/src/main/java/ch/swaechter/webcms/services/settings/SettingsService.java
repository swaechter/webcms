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

import java.util.List;

/**
 * Handles all settings interactions.
 *
 * @author Simon Wächter
 */
public interface SettingsService {

    /**
     * Get all settings.
     *
     * @return All settings
     */
    List<Settings> getAllSettingss();

    /**
     * Get an existing settings.
     *
     * @param id ID of the settings
     * @return Settings
     */
    Settings getSettings(long id);

    /**
     * Check if a settings does exist.
     *
     * @param id ID of the settings
     * @return Status
     */
    boolean isSettingsExisting(long id);

    /**
     * Create a new settings.
     *
     * @param settings New settings
     */
    void createSettings(Settings settings);

    /**
     * Update an existing settings.
     *
     * @param settings Settings
     */
    void updateSettings(Settings settings);

    /**
     * Delete an existing settings.
     *
     * @param id ID of the settings
     */
    void deleteSettings(long id);
}
