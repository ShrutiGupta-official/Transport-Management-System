import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDriverByVehicletypeComponent } from './get-driver-by-vehicletype.component';

describe('GetDriverByVehicletypeComponent', () => {
  let component: GetDriverByVehicletypeComponent;
  let fixture: ComponentFixture<GetDriverByVehicletypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDriverByVehicletypeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetDriverByVehicletypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
