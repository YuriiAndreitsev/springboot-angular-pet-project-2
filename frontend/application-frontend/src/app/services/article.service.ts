import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Article} from "../models/article";
const baseURL = "http://localhost:8080";
@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  constructor(private http: HttpClient) { }

  getAllArticles():Observable<Article[]> {
    return this.http.get<Article[]>(baseURL+"/dashboard/get-all-articles");
  }
}
