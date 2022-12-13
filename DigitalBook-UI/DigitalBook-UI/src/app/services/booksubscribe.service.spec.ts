import { TestBed } from '@angular/core/testing';

import { BooksubscribeService } from './booksubscribe.service';

describe('BooksubscribeService', () => {
  let service: BooksubscribeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BooksubscribeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
