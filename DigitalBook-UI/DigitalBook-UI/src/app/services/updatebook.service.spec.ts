import { TestBed } from '@angular/core/testing';

import { UpdatebookService } from './updatebook.service';

describe('UpdatebookService', () => {
  let service: UpdatebookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdatebookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
