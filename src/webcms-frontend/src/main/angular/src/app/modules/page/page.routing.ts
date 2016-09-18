import {Routes, RouterModule} from "@angular/router";

import {PageComponent} from "./page.component";

const pageroutes: Routes = [
    {
        path: "page",
        component: PageComponent
    }
];

export const pagerouting = RouterModule.forChild(pageroutes);
