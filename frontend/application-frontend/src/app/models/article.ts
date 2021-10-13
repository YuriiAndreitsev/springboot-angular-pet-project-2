import {Author} from "./author";

export interface Article {
    articleId:string;
    articleTitle:string;
    articleContent:string;
    articleAuthor:Author;
   articlePostDateTime:Date;
}
