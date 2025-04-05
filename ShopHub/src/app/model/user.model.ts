import { Address } from "./address.model";

export class Customer{
    firstName!: string;
    lastName !: string;
    password !: string;
    customerId !: number;
    email !: string;
    mobile !: string;
    gender !: string;
    billingAddress !: Address;
    shippingAddress !: Address;    
}