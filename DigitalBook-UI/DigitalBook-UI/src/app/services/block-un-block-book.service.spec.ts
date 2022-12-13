import { TestBed } from '@angular/core/testing';

import { BlockUnBlockBookService } from './block-un-block-book.service';

describe('BlockUnBlockBookService', () => {
  let service: BlockUnBlockBookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BlockUnBlockBookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
