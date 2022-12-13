import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockorunblockComponent } from './blockorunblock.component';

describe('BlockorunblockComponent', () => {
  let component: BlockorunblockComponent;
  let fixture: ComponentFixture<BlockorunblockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlockorunblockComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BlockorunblockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
