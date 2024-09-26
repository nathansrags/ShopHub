import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductgallaryService {

  private url = 'https://dummyjson.com/';
  private category_url = this.url + 'products/category/';
  constructor(private http: HttpClient) { }

  public getProducts(category: string, limit: number, skip: number) {
    return this.http.get(this.category_url + category + '?limit=' + limit);
  }
  private category_list = 'https://dummyjson.com/products/category-list';

  public getCategoryList() {
    return this.http.get(this.category_list);
  }

  public getProduct(id: number) {
    return this.http.get(this.url + 'products/' + id);
  }


}
