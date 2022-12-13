import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksubscribeComponent } from './booksubscribe.component';

describe('BooksubscribeComponent', () => {
  let component: BooksubscribeComponent;
  let fixture: ComponentFixture<BooksubscribeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BooksubscribeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BooksubscribeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
