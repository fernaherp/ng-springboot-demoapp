import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProductModel } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor( private http: HttpClient ) { }

  productList() {

    return this.http.get<ProductModel[]>( 'http://localhost:8080/demoapp/api/products/list' );
  }
}
