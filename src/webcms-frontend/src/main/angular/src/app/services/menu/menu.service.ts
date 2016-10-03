import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Menu} from "./menu.model";

@Injectable()
export class MenuService {

    private url = "/api/menu";

    constructor(private http: Http) {
    }

    getMenus() {
        return this.http.get(this.url).map(data => <Menu[]> data.json()).catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}
