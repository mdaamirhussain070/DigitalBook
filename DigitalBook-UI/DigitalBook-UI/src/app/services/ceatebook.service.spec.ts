import { TestBed } from '@angular/core/testing';

import { CeatebookService } from './ceatebook.service';

describe('CeatebookService', () => {
  let service: CeatebookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CeatebookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
