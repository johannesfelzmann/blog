import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnicsItemComponent } from './technics-item.component';

describe('TechnicsItemComponent', () => {
  let component: TechnicsItemComponent;
  let fixture: ComponentFixture<TechnicsItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TechnicsItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TechnicsItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
