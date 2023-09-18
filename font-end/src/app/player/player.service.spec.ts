import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PlayerService } from './player.service';
import { Player } from './player';

describe('PlayerService', () => {
  let service: PlayerService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [PlayerService]
    });
    service = TestBed.inject(PlayerService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should create a player', () => {
    const fakePlayer: Player = { nome: 'John Doe'};

    service.createPlayer(fakePlayer).subscribe(player => {
      expect(player).toEqual(fakePlayer);
    });

    const req = httpMock.expectOne('http://localhost:8080/jogador');
    expect(req.request.method).toBe('POST');
    req.flush(fakePlayer);
  });

  it('should delete all players', () => {
    service.deleteAll().subscribe(response => {
      expect(response).toBeNull();
    });

    const req = httpMock.expectOne('http://localhost:8080/jogador/all');
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });

  it('should notify when a player is modified', () => {
    let notified = false;
    service.playerModified$.subscribe(() => notified = true);

    service.playerModified();

    expect(notified).toBeTrue();
  });
});
