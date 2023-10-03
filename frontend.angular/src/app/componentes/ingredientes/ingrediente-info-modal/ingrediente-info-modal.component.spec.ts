import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredienteInfoModalComponent } from './ingrediente-info-modal.component';

describe('IngredienteInfoModalComponent', () => {
  let component: IngredienteInfoModalComponent;
  let fixture: ComponentFixture<IngredienteInfoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IngredienteInfoModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngredienteInfoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
