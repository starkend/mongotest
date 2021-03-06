import {Component, OnInit} from '@angular/core';
import {ProductsService} from '../shared/service/products.service';

@Component({
  selector: 'app-products-search',
  templateUrl: './products-search.component.html',
  styleUrls: ['./products-search.component.css']
})
export class ProductsSearchComponent implements OnInit {
  products: Array<any>;
  productColumns: Array<any>;
  searchInput: string;

  constructor(private productsService: ProductsService) {
  }

  ngOnInit() {
    this.searchInput = '';
    this.productColumns = ['name', 'brandName', 'author', 'size', 'addButton'];
    this.getProductList();
  }

  getProductList() {
    this.productsService.getAPIProductList().subscribe(
      data => {
        this.products = data;
      }
    );
  }

  searchProducts() {
    if (this.searchInput === undefined || this.searchInput.trim() === '') {
      this.getProductList();
    } else {
      this.searchProductsByQuery();
    }
  }

  private searchProductsByQuery() {
    this.productsService.searchProducts(this.searchInput)
      .subscribe(data => {
        this.products = data;
      });
  }

  addProduct(product: any) {
    this.productsService.addProduct(product)
      .subscribe( () => {
        this.searchProducts();
      });
  }
}
