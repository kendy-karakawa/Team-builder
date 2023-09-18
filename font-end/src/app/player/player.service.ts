import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from './player';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PlayerService {

  constructor(private http: HttpClient) {};
  private url = "http://localhost:8080/jogador";
  
  private playerModifiedSubject = new Subject<void>();
  playerModified$ = this.playerModifiedSubject.asObservable();

  public createPlayer(player: Player):Observable<any>{
    console.log(player)
    return this.http.post<Player>(this.url,player);
  }

  public deleteAll(): Observable<any>{
    return this.http.delete<any>(this.url+"/all");
  }

  public playerModified() {
    this.playerModifiedSubject.next();
  }
}
