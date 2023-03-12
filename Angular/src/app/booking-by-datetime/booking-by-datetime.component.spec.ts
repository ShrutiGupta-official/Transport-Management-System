import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingByDatetimeComponent } from './booking-by-datetime.component';

describe('BookingByDatetimeComponent', () => {
  let component: BookingByDatetimeComponent;
  let fixture: ComponentFixture<BookingByDatetimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookingByDatetimeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookingByDatetimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
