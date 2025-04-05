import { TestBed } from '@angular/core/testing';

import { HomeImageSliderService } from './home-image-slider.service';

describe('HomeImageSliderService', () => {
  let service: HomeImageSliderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HomeImageSliderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
