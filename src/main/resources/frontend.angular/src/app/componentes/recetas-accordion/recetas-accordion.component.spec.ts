import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecetasAccordionComponent } from './recetas-accordion.component';

describe('RecetasAccordionComponent', () => {
  let component: RecetasAccordionComponent;
  let fixture: ComponentFixture<RecetasAccordionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecetasAccordionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecetasAccordionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
