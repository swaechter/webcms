import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";

import {routing} from "./app.routing";
import {PageModule} from "./modules/page/page.module";
import {AdminModule} from "./modules/admin/admin.module";
import {AppComponent} from "./app.component";

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        routing,
        PageModule,
        AdminModule
    ],
    declarations: [
        AppComponent,
    ],
    bootstrap: [
        AppComponent
    ]
})

export class AppModule {
}
