import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
@Injectable()
export class ConfigService {
  datos: any;
  constructor(private _http: HttpClient) { }

  loadConfig():Promise<void>{
    return new Promise((resolve,reject) => {
      this._http.get('assets/config.json').subscribe(data => {
        this.datos = data
        console.log(data);
        resolve();
      });
    })
  }
}
