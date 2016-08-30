import {Routes, RouterModule} from "@angular/router";

import {AdminComponent} from "./admin.component";
import {OverviewComponent} from "./overview/overview.component";
import {UserComponent} from "./user/user.component";
import {MenuComponent} from "./menu/menu.component";
import {PageComponent} from "./page/page.component";
import {SettingsComponent} from "./settings/settings.component";

const adminroutes: Routes = [
    {
        path: "admin",
        component: AdminComponent,
        children: [
            {
                path: "",
                component: OverviewComponent
            },
            {
                path: "overview",
                component: OverviewComponent
            },
            {
                path: "users",
                component: UserComponent
            },
            {
                path: "menus",
                component: MenuComponent
            },
            {
                path: "pages",
                component: PageComponent
            },
            {
                path: "settings",
                component: SettingsComponent
            }
        ]
    }
];

export const adminrouting = RouterModule.forChild(adminroutes);
