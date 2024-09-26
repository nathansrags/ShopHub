import { Component, Input } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from '../../../model/product.model';
import { ProductgallaryService } from '../../../service/product/productgallary.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { DirectiveModule } from '../../../directive.module';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, RouterModule, DirectiveModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {
  pageTitle = 'Product List';
  imageWidth = 50;
  imageMargin = 2;
  
  errorMessage = '';
  sub!: Subscription;
  
  private _listFilter = '';
  get listFilter(): string {
    return this._listFilter;
  }
  set listFilter(value: string) {
    this._listFilter = value;
    this.filteredProducts = this.performFilter(value);
  }

  filteredProducts: Product[] = [];
  @Input() products!: Product[];
  @Input() category!:string;

  constructor(private productService: ProductgallaryService) {}

  performFilter(filterBy: string): Product[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.products.filter((product: Product) =>
      product.title.toLocaleLowerCase().includes(filterBy));
  }

  ngOnInit(): void {
    console.log(this.products.length);
    // this.sub = this.productService.getProducts(this.category,9,0).subscribe({
    //   next: products => {
    //     this.products = products as Product [];
    //     this.filteredProducts = this.products;
    //   },
    //   error: err => this.errorMessage = err
    // });
  }

  ngOnDestroy(): void {
    //this.sub.unsubscribe();
  }

  onRatingClicked(message: string): void {
    this.pageTitle = 'Product List: ' + message;
  }
}
