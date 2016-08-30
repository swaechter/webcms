import {Component, OnInit} from "@angular/core";

import {MenuService} from "../../../services/menu/menu.service";
import {Menu} from "../../../services/menu/menu.model";

@Component({
    selector: "menu-list-component",
    templateUrl: "menu-list.component.html"
})

export class MenuListComponent implements OnInit {

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
