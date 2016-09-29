import { Component } from "@angular/core";
import { MenuService } from "../../services/menu/menu.service";
export var PageComponent = (function () {
    function PageComponent(menuservice) {
        this.menuservice = menuservice;
    }
    PageComponent.prototype.ngOnInit = function () {
        this.getMenus();
    };
    PageComponent.prototype.getMenus = function () {
        var _this = this;
        this.menuservice.getMenus().subscribe(function (data) { return _this.menus = data; }, function (error) { return console.log(error); });
    };
    PageComponent.decorators = [
        { type: Component, args: [{
                    templateUrl: "page.component.html"
                },] },
    ];
    /** @nocollapse */
    PageComponent.ctorParameters = [
        { type: MenuService, },
    ];
    return PageComponent;
}());
//# sourceMappingURL=page.component.js.map