import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnotherExampleComponent } from './another-example.component';

describe('AnotherExampleComponent', () => {
  let component: AnotherExampleComponent;
  let fixture: ComponentFixture<AnotherExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnotherExampleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnotherExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
