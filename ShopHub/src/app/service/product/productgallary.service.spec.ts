import { TestBed } from '@angular/core/testing';

import { ProductgallaryService } from './productgallary.service';

describe('ProductgallaryService', () => {
  let service: ProductgallaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductgallaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
