import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-image-slider',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './image-slider.component.html',
  styleUrl: './image-slider.component.css'
})

export class ImageSliderComponent {

  slides: Slides[] = this.getSlides();
  @Input() indicatorsVisible = true;
  @Input() animationSpeed = 500;
  @Input() autoPlay = false;
  @Input() autoPlaySpeed = 3000;
  currentSlide = 0;
  hidden = false;

  next() {
    let currentSlide = (this.currentSlide + 1) % this.slides.length;
    this.jumpToSlide(currentSlide);
  }

  previous() {
    let currentSlide =
      (this.currentSlide - 1 + this.slides.length) % this.slides.length;
    this.jumpToSlide(currentSlide);
  }

  jumpToSlide(index: number) {
    this.hidden = true;
    setTimeout(() => {
      this.currentSlide = index;
      this.hidden = false;
    }, this.animationSpeed);
  }

  ngOnInit() {
    if (this.autoPlay) {
      setInterval(() => {
        this.next();
      }, this.autoPlaySpeed);
    }
  }

getSlides(){
  return [
    {
        "id": 1,
        "name": "Top Offers",
        "url": "/assets/images/dashboard/slider/b1.jpg"
    },
    {
        "id": 2,
        "name": "Electronics",
        "url": "/assets/images/dashboard/slider/b2.jpg"
    },
    {
        "id": 3,
        "name": "Fashion",
        "url": "/assets/images/dashboard/slider/b3.jpg"
    }
]
}

}

export interface Slides {
  id: number;
  name: string;
  url: string;
}


