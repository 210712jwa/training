import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LatestPokeComponent } from './latest-poke.component';

describe('LatestPokeComponent', () => {
  let component: LatestPokeComponent;
  let fixture: ComponentFixture<LatestPokeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LatestPokeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LatestPokeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
