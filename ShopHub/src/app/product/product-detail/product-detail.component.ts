import { Component } from '@angular/core';
import { Product } from '../../model/product.model';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProductgallaryService } from '../../service/product/productgallary.service';
import { CommonModule, Location } from '@angular/common';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent {
  pageTitle = 'Product Detail';
  errorMessage = '';
  product!: Product;

  constructor(private route: ActivatedRoute,
    private _location: Location,
    private productService: ProductgallaryService) {
  }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.getProduct(id);
    }
  }

  getProduct(id: number): void {
    this.productService.getProduct(id).subscribe({
      next: products => {
        this.product = products as Product;
      },
      error: err => this.errorMessage = err
    });
  }

  onBack(){
    this.errorMessage = '';
    this._location.back();
  }
}
