package ua.com.application.utils.comparators;

import org.springframework.stereotype.Service;
import ua.com.application.models.NBAPlayer;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayersSortUtil {

    public List<NBAPlayer> sortPlayersByParam(List<NBAPlayer> list, String param) {
        switch (param) {
            case "Steals":
                return list.stream()
                        .sorted(NBAPlayerComparators.STEALS).collect(Collectors.toList());
            case "Rebounds":
                return list.stream()
                        .sorted(NBAPlayerComparators.REBOUNDS).collect(Collectors.toList());
            case "Player":
                return list.stream()
                        .sorted(NBAPlayerComparators.PLAYER_NAME).collect(Collectors.toList());
            case "Score%":
                return list.stream()
                        .sorted(NBAPlayerComparators.OVERALL_SCORING_PERCENTAGE).collect(Collectors.toList());
            case "3p%":
                return list.stream()
                        .sorted(NBAPlayerComparators.BEST_THREE_POINTS_PERCENTAGE).collect(Collectors.toList());
            default:
                return list;
        }
    }
}
