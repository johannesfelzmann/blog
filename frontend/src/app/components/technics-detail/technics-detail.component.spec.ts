import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnicsDetailComponent } from './technics-detail.component';

describe('TechnicsDetailComponent', () => {
  let component: TechnicsDetailComponent;
  let fixture: ComponentFixture<TechnicsDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TechnicsDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TechnicsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
