import {Routes, RouterModule} from "@angular/router";

import {PageComponent} from "./page.component";
import {PageContentComponent} from "./page-content.component";

const pageroutes: Routes = [
    {
        path: "page",
        component: PageComponent,
        children: [
            {
                path: "",
                component: PageContentComponent
            }
        ]
    }
];

export const pagerouting = RouterModule.forChild(pageroutes);
