import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {adminrouting} from "./admin.routing";
import {AdminComponent} from "./admin.component";
import {OverviewComponent} from "./overview/overview.component";
import {UserComponent} from "./user/user.component";
import {UserListComponent} from "./user/user-list.component";
import {MenuComponent} from "./menu/menu.component";
import {MenuListComponent} from "./menu/menu-list.component";
import {PageComponent} from "./page/page.component";
import {PageListComponent} from "./page/page-list.component";
import {SettingsComponent} from "./settings/settings.component";
import {SettingsListComponent} from "./settings/settings-list.component";
import {UserService} from "../../services/user/user.service";
import {MenuService} from "../../services/menu/menu.service";
import {PageService} from "../../services/page/page.service";
import {SettingsService} from "../../services/settings/settings.service";

@NgModule({
    imports: [
        CommonModule,
        adminrouting
    ],
    declarations: [
        AdminComponent,
        OverviewComponent,
        UserComponent,
        UserListComponent,
        MenuComponent,
        MenuListComponent,
        PageComponent,
        PageListComponent,
        SettingsComponent,
        SettingsListComponent
    ],
    providers: [
        UserService,
        MenuService,
        PageService,
        SettingsService
    ]
})

export class AdminModule {
}
