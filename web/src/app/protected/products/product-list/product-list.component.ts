import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../../services/product.service';
import { ProductModel } from '../../../models/product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: ProductModel[] = [];

  constructor( private productsService: ProductService ) { }

  ngOnInit() {
    this.productsService.productList().subscribe( resp => {
      this.productList = resp;
    });
  }

}
