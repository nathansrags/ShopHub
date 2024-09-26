import { TestBed } from '@angular/core/testing';
import { AuthguardInterceptor } from './authguard.interceptor';



describe('AuthguardInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      AuthguardInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: AuthguardInterceptor = TestBed.inject(AuthguardInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
