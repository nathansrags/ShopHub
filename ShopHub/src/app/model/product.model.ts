import { ProductReview } from "./review.model";

export class Product {
    id!: number;
    title!: string;
    thumbnail!: string;
    images!: string[];
    price!: number;
    discountPercentage!: number;
    rating !: number;
    reviews!: ProductReview[];
    sku!:string;
    stock!:string;
  }