import {Component, OnInit} from '@angular/core';
import {ProductsService} from "../shared/service/products.service";

@Component({
  selector: 'app-products-search',
  templateUrl: './products-search.component.html',
  styleUrls: ['./products-search.component.css']
})
export class ProductsSearchComponent implements OnInit {
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
