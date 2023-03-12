import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetVehicleByTypeComponent } from './get-vehicle-by-type.component';

describe('GetVehicleByTypeComponent', () => {
  let component: GetVehicleByTypeComponent;
  let fixture: ComponentFixture<GetVehicleByTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetVehicleByTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetVehicleByTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
