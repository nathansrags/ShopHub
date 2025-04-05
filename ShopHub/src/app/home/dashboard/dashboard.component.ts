import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ImageSliderComponent } from "../image-slider/image-slider.component";
import { TopCategoryService } from '../../service/product/top-category.service';
import { HomeImageSliderService } from '../../service/product/home-image-slider.service';
import { BestSellersComponent } from "../best-sellers/best-sellers.component";
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, ImageSliderComponent, BestSellersComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  catoryList: Categories[] = [];
  slides: Categories[] = [];
  constructor(private sliderService: HomeImageSliderService, private categoryService: TopCategoryService,private spin: NgxSpinnerService) {

  }

  ngOnInit(): void {
    this.loadSlides();
    this.loadCategories();
    this.spin.hide();
  }

  async loadModules(){
    await this.loadSlides();
    await this.loadCategories();
  }
  async loadSlides() {
    this.sliderService.getSlides().subscribe((data) => {
      const categoryData = data as Categories[];
      this.slides = categoryData;      
    });
  }

  loadCategories() {
    this.categoryService.getCategories().subscribe((data) => {
      const categoryData = data as Categories[];
      this.catoryList = categoryData;
    })
  }
}

export class Categories {
  url!: string;
  id!: number;
  name!: string;

  constructor(url: string, name: string) {
    this.url = url;
    this.name = name;
  }
}
