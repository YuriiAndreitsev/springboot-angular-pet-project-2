import { TestBed } from '@angular/core/testing';

import { NBAPlayerService } from './nbaplayer.service';

describe('NBAPlayerService', () => {
  let service: NBAPlayerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NBAPlayerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
