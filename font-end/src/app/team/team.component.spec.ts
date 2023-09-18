import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamComponent } from './team.component';
import { TeamService } from './team.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { PlayerService } from '../player/player.service';
import { of, throwError } from 'rxjs';

describe('TeamComponent', () => {
  let component: TeamComponent;
  let fixture: ComponentFixture<TeamComponent>;
  let teamService: TeamService;
  let playerService: PlayerService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, FormsModule],
      declarations: [TeamComponent],
      providers: [TeamService, PlayerService],
    }).compileComponents();

    teamService = TestBed.inject(TeamService)

    fixture = TestBed.createComponent(TeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call getAllTeams on init', () => {
    spyOn(component, 'getAllTeams');
    component.ngOnInit();
    expect(component.getAllTeams).toHaveBeenCalled();
  });

  it('should handle success response from getAllTeams', () => {
    const response = { 'Team 1': ['Player 1', 'Player 2'] };
    spyOn(teamService, "getTeams").and.returnValue(of(response));
    
    fixture.detectChanges();
    component.getAllTeams();

    expect(component.teams.length).toBe(1);
    expect(component.teams[0].name).toBe('Team 1');
    expect(component.teams[0].playerList.length).toBe(2);
  });

  it('should handle error response from getTeams', () => {
    spyOn(console, 'log');
    spyOn(teamService, 'getTeams').and.returnValue(throwError('error'));
    component.getAllTeams();
    expect(console.log).toHaveBeenCalledWith('error');
  });

 
});
