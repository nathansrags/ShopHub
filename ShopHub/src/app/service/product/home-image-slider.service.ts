import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeImageSliderService {

  private URL = '/assets/mockJson/slides.json';

  constructor(private http: HttpClient) { }

  public getSlides() {
    return this.http.get(this.URL);
  }
}
