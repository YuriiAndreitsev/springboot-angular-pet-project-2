package ua.com.application.utils.comparators;

import ua.com.application.models.NBAPlayer;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorChaining {
    public static Comparator<NBAPlayer> chainComparators(List<Comparator<NBAPlayer>> list) {
        return list.stream().reduce(Comparator::thenComparing).orElse(comparing(NBAPlayer::getName));
    }

}
