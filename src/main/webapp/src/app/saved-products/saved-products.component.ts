import { Component, OnInit } from '@angular/core';
import {ProductsService} from "../shared/service/products.service";

@Component({
  selector: 'app-saved-products',
  templateUrl: './saved-products.component.html',
  styleUrls: ['./saved-products.component.css']
})
export class SavedProductsComponent implements OnInit {
  products: Array<any>;
  productColumns: Array<any>;

  constructor(private productsService: ProductsService) {
  }

  ngOnInit() {
    this.getProductList();
    this.productColumns = ['name','brandName'];
  }

  getProductList() {
    this.productsService.getProductList().subscribe(
      data => {
        this.products = data;
      }
    );
  }


}
