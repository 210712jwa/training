import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewShipsComponent } from './view-ships.component';

describe('ViewShipsComponent', () => {
  let component: ViewShipsComponent;
  let fixture: ComponentFixture<ViewShipsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewShipsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewShipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
