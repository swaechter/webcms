import {Component, OnInit} from "@angular/core";

import {UserService} from "../../../services/user/user.service";
import {User} from "../../../services/user/user.model";

@Component({
    selector: "user-list-component",
    templateUrl: "user-list.component.html"
})

export class UserListComponent implements OnInit {

    users: User[];

    constructor(private userservice: UserService) {
    }

    ngOnInit() {
        this.getUsers();
    }

    getUsers() {
        this.userservice.getUsers().subscribe((data: User[]) => this.users = data, error => console.log(error));
    }
}
