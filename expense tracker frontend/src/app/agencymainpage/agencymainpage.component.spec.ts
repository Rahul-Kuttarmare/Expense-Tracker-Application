import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgencymainpageComponent } from './agencymainpage.component';

describe('AgencymainpageComponent', () => {
  let component: AgencymainpageComponent;
  let fixture: ComponentFixture<AgencymainpageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgencymainpageComponent]
    });
    fixture = TestBed.createComponent(AgencymainpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
