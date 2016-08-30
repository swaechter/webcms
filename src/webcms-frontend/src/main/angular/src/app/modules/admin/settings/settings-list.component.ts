import {Component, OnInit} from "@angular/core";

import {SettingsService} from "../../../services/settings/settings.service";
import {Settings} from "../../../services/settings/settings.model";

@Component({
    selector: "settings-list-component",
    templateUrl: "settings-list.component.html"
})

export class SettingsListComponent implements OnInit {

    settings: Settings[];

    constructor(private settingsservice: SettingsService) {
    }

    ngOnInit() {
        this.getSettings();
    }

    getSettings() {
        this.settingsservice.getSettings().subscribe((data: Settings[]) => this.settings = data, error => console.log(error));
    }
}
