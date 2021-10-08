package ua.com.application.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "players")
public class NBAPlayer {
    @Id
    private String id;
    private String name;
    private Team team;
    private double pointsPerGame;
    private int gamesPlayed;
    private double overallScoringPercentage;
    private double threePointPercentage;
    private double rebounds;
    private double steels;

}
