import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {pagerouting} from "./page.routing";
import {PageComponent} from "./page.component";
import {PageService} from "../../services/page/page.service";

@NgModule({
    imports: [
        CommonModule,
        pagerouting
    ],
    declarations: [
        PageComponent,
    ],
    providers: [
        PageService
    ]
})

export class PageModule {
}
