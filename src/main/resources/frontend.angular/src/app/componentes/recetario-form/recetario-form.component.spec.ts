import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecetarioFormComponent } from './recetario-form.component';

describe('RecetarioFormComponent', () => {
  let component: RecetarioFormComponent;
  let fixture: ComponentFixture<RecetarioFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecetarioFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecetarioFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
