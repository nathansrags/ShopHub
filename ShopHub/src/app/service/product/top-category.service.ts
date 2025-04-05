import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class TopCategoryService {

  private URL = '/assets/mockJson/categories.json';

  constructor(private http: HttpClient) { }

  public getCategories() {
    return this.http.get(this.URL);
  }
}
