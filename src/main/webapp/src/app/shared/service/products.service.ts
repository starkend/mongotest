import {Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  getSavedProductList(): Observable<any> {
    return this.http.get(environment.apiUrl + '/savedProductList');
  }

  getAPIProductList(): Observable<any> {
    return this.http.get(environment.apiUrl + '/apiProductList');
  }

  searchProducts(searchInput: string): Observable<any>  {
    return this.http.post<any>(environment.apiUrl + '/searchProducts', searchInput);
  }

  addProduct(product: any): Observable<any>  {
    return this.http.post<any>(environment.apiUrl + '/addProduct', product );
  }
}
