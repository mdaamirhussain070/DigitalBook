import { TestBed } from '@angular/core/testing';

import { ViewallsubscribedbookService } from './viewallsubscribedbook.service';

describe('ViewallsubscribedbookService', () => {
  let service: ViewallsubscribedbookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewallsubscribedbookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
