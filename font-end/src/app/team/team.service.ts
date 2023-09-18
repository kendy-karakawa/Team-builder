import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Team } from './team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http:HttpClient) { };

  private url = "http://localhost:8080/times";

  public getTeams():Observable<{[key: string]: string[]}>{
    return this.http.get<{[key: string]: string[]}>(this.url);
  }
}
