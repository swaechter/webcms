import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Page} from "./page.model";

@Injectable()
export class PageService {

    constructor(private http: Http) {
    }

    getPages() {
        return this.http.get("/api/pages/get").map(data => <Page[]> data.json()).catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}
