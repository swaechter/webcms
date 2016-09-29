import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { pagerouting } from "./page.routing";
import { PageComponent } from "./page.component";
import { PageService } from "../../services/page/page.service";
export var PageModule = (function () {
    function PageModule() {
    }
    PageModule.decorators = [
        { type: NgModule, args: [{
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
                },] },
    ];
    /** @nocollapse */
    PageModule.ctorParameters = [];
    return PageModule;
}());
//# sourceMappingURL=page.module.js.map