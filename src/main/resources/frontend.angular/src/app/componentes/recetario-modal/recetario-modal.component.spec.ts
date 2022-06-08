import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecetarioModalComponent } from './recetario-modal.component';

describe('RecetarioModalComponent', () => {
  let component: RecetarioModalComponent;
  let fixture: ComponentFixture<RecetarioModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecetarioModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecetarioModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
