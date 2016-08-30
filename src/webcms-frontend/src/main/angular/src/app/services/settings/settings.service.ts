import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Settings} from "./settings.model";

@Injectable()
export class SettingsService {

    constructor(private http: Http) {
    }

    getSettings() {
        return this.http.get("/api/settings/get").map(data => <Settings[]> data.json()).catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}
