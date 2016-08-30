import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Menu} from "./menu.model";

@Injectable()
export class MenuService {

    constructor(private http: Http) {
    }

    getMenus() {
        return this.http.get("/api/menus/get").map(data => <Menu[]> data.json()).catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}
