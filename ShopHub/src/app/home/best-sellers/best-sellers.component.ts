import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterModule } from '@angular/router';
import { NgImageSliderModule } from 'ng-image-slider';
import { ProductgallaryService } from '../../service/product/productgallary.service';
import { ProductResponse } from '../../model/iproductresponse.model';
import { NgImageData } from '../../model/ImageResponse';

@Component({
  selector: 'app-best-sellers',
  standalone: true,
  imports: [CommonModule, RouterModule, NgImageSliderModule],
  templateUrl: './best-sellers.component.html',
  styleUrl: './best-sellers.component.css'
})
export class BestSellersComponent {

  imageObject: NgImageData[] = [];
  @Input() category!: string;
  @Input() hasBestDeal!: string;
  isBestDeal: boolean = false;
  constructor(private productGService: ProductgallaryService) { }

  ngOnInit(): void {
    this.isBestDeal = this.hasBestDeal === 'true';    
    this.getProducts(this.category);    
  }

  getProducts(category: string) {
    this.productGService.getProductsByCategory(category,0, 0).subscribe((data) => {
      const res = data as ProductResponse
      const products = res.products;
      for (let index = 0; index < products.length; index++) {
        const element = products[index];
        let product: NgImageData = this.addProduct(element.title, element.images, element.thumbnail);        
        this.imageObject.push(product);
      }      
    })
  }

  addProduct(title: string, image: string[], thumbnail: string): NgImageData {
    let product = new NgImageData();
    product.image = image[0];
    product.thumbImage = thumbnail;
    product.title = title;
    return product;
  }
  
}


