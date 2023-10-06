import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddrecordComponent } from './addrecord.component';

describe('AddrecordComponent', () => {
  let component: AddrecordComponent;
  let fixture: ComponentFixture<AddrecordComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddrecordComponent]
    });
    fixture = TestBed.createComponent(AddrecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
