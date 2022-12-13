import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewallsubscribedbookComponent } from './viewallsubscribedbook.component';

describe('ViewallsubscribedbookComponent', () => {
  let component: ViewallsubscribedbookComponent;
  let fixture: ComponentFixture<ViewallsubscribedbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewallsubscribedbookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewallsubscribedbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
