import { CommonModule } from '@angular/common';
import { Component, input, Input } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Product } from '../../../model/product.model';

@Component({
  selector: 'app-product-grid',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './product-grid.component.html',
  styleUrl: './product-grid.component.css'
})
export class ProductGridComponent {

  @Input() products!: Product[];
  constructor(){}
  ngOnInit() :void{

  }

}
