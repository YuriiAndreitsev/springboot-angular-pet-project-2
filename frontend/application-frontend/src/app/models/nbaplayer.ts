import {Team} from "./team";

export interface NBAPlayer {

  // constructor(name: string, team: Team, pointsPerGame: number, gamesPlayed: number, overallScoringPercentage: number, threePointPercentage: number, rebounds: number, steels: number) {
  //   this.name = name;
  //   this.team = team;
  //   this.pointsPerGame = pointsPerGame;
  //   this.gamesPlayed = gamesPlayed;
  //   this.overallScoringPercentage = overallScoringPercentage;
  //   this.threePointPercentage = threePointPercentage;
  //   this.rebounds = rebounds;
  //   this.steels = steels;
  // }

  id?: string;
  name: string;
  team: Team;
  pointsPerGame: number;
  gamesPlayed: number;
  overallScoringPercentage: number;
  threePointPercentage: number;
  rebounds: number;
  steels: number;
}
