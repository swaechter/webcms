import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {pagerouting} from "./page.routing";
import {PageComponent} from "./page.component";
import {PageContentComponent} from "./page-content.component";
import {PageNavigationComponent} from "./page-navigation.component";
import {PageService} from "../../services/page/page.service";

@NgModule({
    imports: [
        CommonModule,
        pagerouting
    ],
    declarations: [
        PageComponent,
        PageNavigationComponent,
        PageContentComponent
    ],
    providers: [
        PageService
    ]
})

export class PageModule {
}
