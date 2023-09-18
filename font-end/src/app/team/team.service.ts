import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http:HttpClient) { };

  private url = `${environment.API}/times`;

  public getTeams():Observable<{[key: string]: string[]}>{
    return this.http.get<{[key: string]: string[]}>(this.url);
  }
}
