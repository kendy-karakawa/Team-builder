import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';

import { TeamService } from './team.service';

describe('TeamService', () => {
  let service: TeamService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [TeamService],
    });
    service = TestBed.inject(TeamService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch teams', () => {
    const fakeTeams = {
      'Team1': ['Player1', 'Player2'],
      'Team2': ['Player3', 'Player4']
    };

    service.getTeams().subscribe(teams => {
      expect(teams).toEqual(fakeTeams);
    });

    const request = httpMock.expectOne('http://localhost:8080/times');
    expect(request.request.method).toBe('GET');
    request.flush(fakeTeams);
  });



});
