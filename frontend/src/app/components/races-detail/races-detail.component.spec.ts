import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RacesDetailComponent } from './races-detail.component';

describe('RacesDetailComponent', () => {
  let component: RacesDetailComponent;
  let fixture: ComponentFixture<RacesDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RacesDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RacesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
