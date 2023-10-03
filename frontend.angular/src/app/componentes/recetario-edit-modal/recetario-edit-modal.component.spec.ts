import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecetarioEditModalComponent } from './recetario-edit-modal.component';

describe('RecetarioEditModalComponent', () => {
  let component: RecetarioEditModalComponent;
  let fixture: ComponentFixture<RecetarioEditModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecetarioEditModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecetarioEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
