import {Component, OnInit} from "@angular/core";

import {PageService} from "../../../services/page/page.service";
import {Page} from "../../../services/page/page.model";

@Component({
    selector: "page-list-component",
    templateUrl: "page-list.component.html"
})

export class PageListComponent implements OnInit {

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
