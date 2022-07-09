import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RacesItemComponent } from './races-item.component';

describe('RacesItemComponent', () => {
  let component: RacesItemComponent;
  let fixture: ComponentFixture<RacesItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RacesItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RacesItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
