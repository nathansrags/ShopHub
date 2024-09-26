import { Product } from "./product.model";

export interface ProductResponse {
    limit: number;
    products: Product[];
    skip: number;
    total: number;
  }
  