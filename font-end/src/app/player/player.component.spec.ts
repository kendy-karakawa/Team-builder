import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerComponent } from './player.component';
import { PlayerService } from './player.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { of } from 'rxjs';
import { Player } from './player';

describe('PlayerComponent', () => {
  let component: PlayerComponent;
  let fixture: ComponentFixture<PlayerComponent>;
  let playerService: PlayerService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, FormsModule],
      declarations: [PlayerComponent],
      providers: [PlayerService]
    }).compileComponents();

    playerService = TestBed.inject(PlayerService);

    fixture = TestBed.createComponent(PlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call createPlayer when player name is not null', () => {
    spyOn(playerService, "createPlayer").and.returnValue(of(null));
    const fakePlayer: Player = { nome: 'John Doe'};
    component.player = fakePlayer

    component.postPlayer();
    expect(playerService.createPlayer).toHaveBeenCalledWith(fakePlayer);
  });

  it('should alert when player name is null', () => {
    spyOn(window, 'alert');
    component.player.nome = null;
    component.postPlayer();
    expect(window.alert).toHaveBeenCalledWith('Imput esta vazio');
  });

  it('should call deleteAll on deleteAll', () => {
    spyOn(playerService, "deleteAll").and.returnValue(of(null))
    component.deleteAll();
    expect(playerService.deleteAll).toHaveBeenCalled();
  });
});
