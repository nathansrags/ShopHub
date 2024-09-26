import { CommonModule } from '@angular/common';
import { Component, Output } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProductgallaryService } from '../../service/product/productgallary.service';
import { Product } from '../../model/product.model';
import { ProductResponse } from '../../model/iproductresponse.model';
import { ProductGridComponent } from "./product-grid/product-grid.component";
import { ProductListComponent } from "./product-list/product-list.component";


@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [CommonModule, RouterModule, ProductGridComponent, ProductListComponent],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent {
  constructor(private activatedRoute: ActivatedRoute, private router: Router, private productGService: ProductgallaryService) { }
  category: any = '';
  @Output() products: Product[] = [];
  category_list: string[] = []
  displayMode: number = 1

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe({
      next: (parms) => {
        let category = parms.get('category');
        this.category = category;
        this.getProducts(this.category, 9, 0);
      }
    });
    this.getCategoryList();

  }


  getProducts(category: string, limit: number, skip: number) {
    this.productGService.getProducts(category, limit, skip).subscribe((data) => {
      const res = data as ProductResponse
      this.products = res.products;
    })
  }

  getCategoryList() {
    this.productGService.getCategoryList().subscribe((data) => {
      this.category_list = data as string[];
      console.log(this.category_list);
    })
  }
  onDisplayModeChange(mode: number): void {
    this.displayMode = mode;
  }
}
