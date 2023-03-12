import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDriverListByIdComponent } from './get-driver-list-by-id.component';

describe('GetDriverListByIdComponent', () => {
  let component: GetDriverListByIdComponent;
  let fixture: ComponentFixture<GetDriverListByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDriverListByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetDriverListByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
