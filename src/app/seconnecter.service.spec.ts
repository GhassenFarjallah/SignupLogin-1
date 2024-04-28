import { TestBed } from '@angular/core/testing';

import { SeconnecterService } from './seconnecter.service';

describe('SeconnecterService', () => {
  let service: SeconnecterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeconnecterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
