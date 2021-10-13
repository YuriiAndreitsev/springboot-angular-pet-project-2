package ua.com.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.application.models.NBAPlayer;
import ua.com.application.repository.NBAPlayerRepository;
import ua.com.application.utils.comparators.ComparatorChaining;
import ua.com.application.utils.comparators.NBAPlayerComparators;
import ua.com.application.utils.comparators.NBAPlayersComparatorMapUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NBAPlayerService {
    private final NBAPlayerRepository nbaPlayerRepository;
    @Autowired
    NBAPlayersComparatorMapUtil comparatorMapUtil;

    public NBAPlayerService(NBAPlayerRepository nbaPlayerRepository) {
        this.nbaPlayerRepository = nbaPlayerRepository;
    }

    public List<NBAPlayer> getPlayersComparedByParams(List<String> params) {
        List<Comparator<NBAPlayer>> comparators = params.stream()
                .map(comparatorMapUtil.getNbaPlayerComparatorsMap()::get)
                .collect(Collectors.toList());
        Comparator<NBAPlayer> resultingComparator = ComparatorChaining.chainComparators(comparators);
        return nbaPlayerRepository.findAll().stream().sorted(resultingComparator).collect(Collectors.toList());
    }

    public List<NBAPlayer> findAllPlayers() {
        return nbaPlayerRepository.findAll();
    }

    public NBAPlayer addNBAPlayer(NBAPlayer player) {
        return nbaPlayerRepository.insert(player);
    }

    public List<NBAPlayer> findNBAPlayersByTeam(String teamName) {
        return nbaPlayerRepository.findAllByTeamContaining(teamName);
    }

    public List<NBAPlayer> findNBAPlayersBy3PointPercentageGreaterThan(double percentage) {
        return nbaPlayerRepository.findAllByThreePointPercentageIsGreaterThan(percentage);
    }
}
