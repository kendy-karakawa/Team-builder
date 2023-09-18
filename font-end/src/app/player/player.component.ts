import { Component } from '@angular/core';
import { PlayerService } from './player.service';
import { Player } from './player';


@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent {

  constructor(
    private playerService: PlayerService,
  ){};

  player: Player = new Player();
  loading: boolean = false

  postPlayer():void{
    if(this.player.nome === null){
      alert("Imput esta vazio")
      return
    }
    this.loading = true;
    this.playerService.createPlayer(this.player).subscribe(
      result => {
        this.player = new Player();
        this.playerService.playerModified()
        this.loading = false
      },
      error =>{
        console.log(error)
        this.loading = false
      }
    )
  }

  deleteAll():void{
    this.playerService.deleteAll().subscribe(
      result =>{
        console.log(result);
        this.playerService.playerModified()
      },
      error => {
        console.log(error)
      }
    )
  }



}
