import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecetariosListComponent } from './recetarios-list.component';

describe('ListComponent', () => {
  let component: RecetariosListComponent;
  let fixture: ComponentFixture<RecetariosListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecetariosListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecetariosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
