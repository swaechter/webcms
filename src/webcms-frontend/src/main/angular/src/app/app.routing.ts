import {Routes, RouterModule} from "@angular/router";

const routes: Routes = [
    {
        path: "",
        redirectTo: "/page",
        pathMatch: "full"
    },
    {
        path: "page",
        redirectTo: "/page",
        pathMatch: "full"
    },
    {
        path: "admin",
        redirectTo: "/admin",
        pathMatch: "full"
    },
    {
        path: "**",
        redirectTo: "/page",
        pathMatch: "full"
    }
];

export const routing = RouterModule.forRoot(routes, {
    useHash: true
});
