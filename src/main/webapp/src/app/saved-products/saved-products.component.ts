import {Component, OnInit} from '@angular/core';
import {ProductsService} from '../shared/service/products.service';

@Component({
  selector: 'app-saved-products',
  templateUrl: './saved-products.component.html',
  styleUrls: ['./saved-products.component.css']
})
export class SavedProductsComponent implements OnInit {
  products: Array<any>;
  productColumns: Array<any>;
  searchByNameOrBrandInput: string;

  constructor(private productsService: ProductsService) {
  }

  ngOnInit() {
    this.getSavedProductList();
    this.productColumns = ['name', 'brandName', 'size', 'author', 'deleteButton'];
  }

  getSavedProductList() {
    this.productsService.getSavedProductList().subscribe(
      data => {
        this.products = data;
      }
    );
  }

  deleteProduct(product: any) {
    this.productsService.deleteProduct(product.id)
      .subscribe(
        () => {
          this.getSavedProductList();
        }
      );
  }

  searchByNameOrBrand() {
    if (this.searchByNameOrBrandInput === '' || this.searchByNameOrBrandInput === undefined) {
      this.getSavedProductList();
    } else {
      this.productsService.searchByNameOrBrand(this.searchByNameOrBrandInput)
        .subscribe(data => {
          this.products = data;
        });
    }
  }

}
