import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";

import {routing} from "./application.routing";
import {PageModule} from "./modules/page/page.module";
import {AdminModule} from "./modules/admin/admin.module";
import {ApplicationComponent} from "./application.component";

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        routing,
        PageModule,
        AdminModule
    ],
    declarations: [
        ApplicationComponent,
    ],
    bootstrap: [
        ApplicationComponent
    ]
})

export class ApplicationModule {
}
