import {Component, OnInit} from '@angular/core';
import {NBAPlayerService} from "../../services/nbaplayer.service";
import {NBAPlayer} from "../../models/nbaplayer";
import {ArticleService} from "../../services/article.service";
import {Article} from "../../models/article";
import {CdkDragDrop, moveItemInArray} from "@angular/cdk/drag-drop";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  players: NBAPlayer[] = [];
  tableHeadNames: string[] = ['No.', 'Player', 'GamesPlayed', 'PointsPerGame', 'Team', 'OverallScoring%', '3p%', 'Rebounds', 'Steals'];
  config: any;
  collection = {count: this.players.length, data: this.players};
  tableHeadNameElement: string = "";
  // comparatorParams: string[] = [];
  // comparatorParams: string[] = [];

  comparatorsNames: string[] = [];
  articles: Article[] = [];

  constructor(private playerService: NBAPlayerService, private articleService: ArticleService) {
    this.config = {itemsPerPage: 5, currentPage: 1, totalItems: this.collection.count}
  }

  drop(event: CdkDragDrop<string[]>) {
    moveItemInArray(this.comparatorsNames, event.previousIndex, event.currentIndex);
    this.sendComparatorParameters(this.comparatorsNames);
  }

  getAllArticles() {
    this.articleService.getAllArticles().subscribe(articles => this.articles = articles);
  }


  // setComparators(event: any) {
  //   if (event.target.value == "clear") {
  //     this.comparatorParams = [];
  //     this.getAllNBAPlayers();
  //   } else {
  //     this.comparatorParams.push(event.target.value);
  //     this.sendComparatorParameters(this.comparatorParams);
  //   }
  // }

  sendComparatorParameters(params: string[]) {
    this.playerService.sendComparatorParams(params).subscribe(players => this.players = players);
  }

  tableHeadNameMethod(element: string) {
    if (this.tableHeadNameElement == "") {
      this.tableHeadNameElement = element;
      this.getAllNBAPlayersSorted(this.tableHeadNameElement);
    } else if (this.tableHeadNameElement == element) {
      this.players.reverse();
    } else {
      this.getAllNBAPlayersSorted(element);
      this.tableHeadNameElement = element;
    }

  }

  pageChanged(event: any) {
    this.config.currentPage = event;
  }

  getAllNBAPlayers() {
    this.playerService.getAllPlayers().subscribe(players => this.players = players);
  }

  getComparatorsNames() {
    this.playerService.comparatorsNames().subscribe(c => this.comparatorsNames = c);
  }

  getAllNBAPlayersSorted(param: string) {
    this.playerService.getAllPlayersSorted(param).subscribe(players => this.players = players);
  }

  ngOnInit(): void {
    this.getAllArticles();
    this.getComparatorsNames();
    this.getAllNBAPlayers();
    // this.comparatorParams= this.comparatorsNames;
  }
}

