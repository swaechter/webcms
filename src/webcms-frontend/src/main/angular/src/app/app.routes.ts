import {Routes, RouterModule} from "@angular/router";

import {HomeComponent} from "./home/home.component";
import {AboutComponent} from "./about/about.component";

const routes: Routes = [
    {
        path: "",
        children: [
            {
                path: "",
                redirectTo: "/home",
                pathMatch: "full"
            },
            {
                path: "home",
                component: HomeComponent
            },
            {
                path: "about",
                component: AboutComponent
            }
        ]
    }
];

export const approutes = RouterModule.forRoot(routes, {
    useHash: true
});
