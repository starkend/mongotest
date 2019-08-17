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
    this.productColumns = ['name','brandName'];
    this.getProductList();
  }

  getProductList() {
    this.productsService.getAPIProductList().subscribe(
      data => {
        this.products = data;
      }
    );
  }
}
