import {Component, OnInit} from "@angular/core";

import {MenuService} from "../../services/menu/menu.service";
import {Menu} from "../../services/menu/menu.model";

@Component({
    selector: "page-navigation-component",
    templateUrl: "page-navigation.component.html"
})

export class PageNavigationComponent implements OnInit {

    menus: Menu[];

    constructor(private menuservice: MenuService) {
    }

    ngOnInit() {
        this.getMenus();
    }

    getMenus() {
        this.menuservice.getMenus().subscribe((data: Menu[]) => this.menus = data, error => console.log(error));
    }
}
