import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {User} from "./user.model";

@Injectable()
export class UserService {

    private url = "/api/user";

    constructor(private http: Http) {
    }

    getUsers() {
        return this.http.get(this.url).map(data => <User[]> data.json()).catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}
