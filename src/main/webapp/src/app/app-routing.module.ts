import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductsSearchComponent} from './products-search/products-search.component';
import {HomeComponent} from './home/home.component';
import {SavedProductsComponent} from './saved-products/saved-products.component';

const routes: Routes = [
  { path: 'products-search', component: ProductsSearchComponent },
  { path: 'saved-products', component: SavedProductsComponent },
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent }];

@NgModule({
  imports: [RouterModule.forRoot(
    routes,
    {
      enableTracing: false // <-- debugging purposes only
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
