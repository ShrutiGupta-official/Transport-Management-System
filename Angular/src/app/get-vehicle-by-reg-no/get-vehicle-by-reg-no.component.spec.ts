import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetVehicleByRegNoComponent } from './get-vehicle-by-reg-no.component';

describe('GetVehicleByRegNoComponent', () => {
  let component: GetVehicleByRegNoComponent;
  let fixture: ComponentFixture<GetVehicleByRegNoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetVehicleByRegNoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetVehicleByRegNoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
