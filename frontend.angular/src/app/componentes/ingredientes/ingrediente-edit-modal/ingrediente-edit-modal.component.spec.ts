import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredienteEditModalComponent } from './ingrediente-edit-modal.component';

describe('IngredienteEditModalComponent', () => {
  let component: IngredienteEditModalComponent;
  let fixture: ComponentFixture<IngredienteEditModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IngredienteEditModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngredienteEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
