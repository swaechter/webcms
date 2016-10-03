import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Settings} from "./settings.model";

@Injectable()
export class SettingsService {

    private url = "/api/settings";

    constructor(private http: Http) {
    }

    getSettings() {
        return this.http.get(this.url).map(data => <Settings[]> data.json()).catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}
