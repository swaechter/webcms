import {platformBrowserDynamic} from "@angular/platform-browser-dynamic";
import {enableProdMode} from "@angular/core";
import {ApplicationModule, environment} from "./app/";

if (environment.production) {
    enableProdMode();
}

platformBrowserDynamic().bootstrapModule(ApplicationModule);
