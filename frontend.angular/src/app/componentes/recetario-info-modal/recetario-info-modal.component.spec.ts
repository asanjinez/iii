import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecetarioInfoModalComponent } from './recetario-info-modal.component';

describe('IngredientesListComponent', () => {
  let component: RecetarioInfoModalComponent;
  let fixture: ComponentFixture<RecetarioInfoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecetarioInfoModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecetarioInfoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
