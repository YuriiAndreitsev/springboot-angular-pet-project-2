package ua.com.application.utils.comparators;

import ua.com.application.models.NBAPlayer;

import java.util.Comparator;

public enum NBAPlayerComparators implements Comparator<NBAPlayer> {
    GAMES_PLAYED(Comparator.comparing(NBAPlayer::getGamesPlayed)),
    TEAM(Comparator.comparing(NBAPlayer::getTeam)),
    REBOUNDS(Comparator.comparing(NBAPlayer::getRebounds)),
    STEALS(Comparator.comparing(NBAPlayer::getSteels)),
    BEST_THREE_POINTS_PERCENTAGE(Comparator.comparing(NBAPlayer::getThreePointPercentage)),
    OVERALL_SCORING_PERCENTAGE(Comparator.comparing(NBAPlayer::getOverallScoringPercentage)),
    PLAYER_NAME(Comparator.comparing(NBAPlayer::getName)),
    POINTS_PER_GAME(Comparator.comparing(NBAPlayer::getPointsPerGame));

    Comparator<NBAPlayer> comparator;

    NBAPlayerComparators(Comparator<NBAPlayer> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(NBAPlayer o1, NBAPlayer o2) {
        int result = comparator.compare(o1, o2);
        if (result != 0) {
            return result;
        }
        return 0;
    }
}
