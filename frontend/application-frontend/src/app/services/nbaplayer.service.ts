import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {NBAPlayer} from "../models/nbaplayer";

const baseURL = "http://localhost:8080";

@Injectable({
  providedIn: 'root'
})


export class NBAPlayerService {


  constructor(private http: HttpClient) {
  }

  getAllPlayers(): Observable<NBAPlayer[]> {
    return this.http.get<NBAPlayer[]>(baseURL+"/dashboard/all");
  }

  getAllPlayersSorted(param:string) {
    return this.http.get<NBAPlayer[]>(baseURL+"/dashboard/sorted", {params: {param}});
  }

  sendComparatorParams(params: string[]) {
    return this.http.get<NBAPlayer[]>(baseURL+"/dashboard/comparators", {params: {params}});
  }

  comparatorsNames(): Observable<string[]> {
    return this.http.get<string[]>(baseURL+"/dashboard/comparators-names");
  }
}
