import {Component} from "@angular/core";

import {PageService} from "../../services/page/page.service";
import {Page} from "../../services/page/page.model";

@Component({
    selector: "page-content-component",
    templateUrl: "page-content.component.html"
})

export class PageContentComponent {
    pages: Page[];

    constructor(private pageservice: PageService) {
    }

    ngOnInit() {
        this.getPages();
    }

    getPages() {
        this.pageservice.getPages().subscribe((data: Page[]) => this.pages = data, error => console.log(error));
    }
}
