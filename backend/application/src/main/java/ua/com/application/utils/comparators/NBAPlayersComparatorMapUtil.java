package ua.com.application.utils.comparators;

import org.springframework.stereotype.Component;
import ua.com.application.models.NBAPlayer;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class NBAPlayersComparatorMapUtil {
    private Map<String, Comparator<NBAPlayer>> nbaPlayerComparatorsMap;

    public NBAPlayersComparatorMapUtil() {
        nbaPlayerComparatorsMap = Arrays.stream(NBAPlayerComparators.values()).collect(Collectors.toMap(Enum::name, e -> e));
    }

    public Map<String, Comparator<NBAPlayer>> getNbaPlayerComparatorsMap() {
        return nbaPlayerComparatorsMap;
    }
}
