import { Component, OnInit } from '@angular/core';
import { TeamService } from './team.service';
import { Team } from './team';
import { Player } from '../player/player';
import { PlayerService } from '../player/player.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.scss'],
})
export class TeamComponent implements OnInit {
  constructor(
    private teamService: TeamService,
    private playerService: PlayerService
    
    ) {}

  team: Team = new Team();
  teams: Team[] = []

  ngOnInit(): void {
    this.getAllTeams();
    this.playerService.playerModified$.subscribe(() => {
      this.getAllTeams();
    });
  }

  getAllTeams(): void {
    this.teamService.getTeams().subscribe(
      (result) => {
        this.teams = Object.entries(result).map(([teamName, playerNames]) => {
          const team = new Team();
          team.name = teamName;
          team.playerList = playerNames.map(playerName => {
            const player = new Player();
            player.nome = playerName;
            return player;
          });
          return team;
        });
        console.log(this.teams);
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
