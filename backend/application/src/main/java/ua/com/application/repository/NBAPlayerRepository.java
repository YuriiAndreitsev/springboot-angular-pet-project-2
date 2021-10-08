package ua.com.application.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.com.application.models.NBAPlayer;

import java.util.List;

@Repository
public interface NBAPlayerRepository extends MongoRepository<NBAPlayer, String> {
    List<NBAPlayer> findAllByTeamContaining(String teamName);

    List<NBAPlayer> findAllByThreePointPercentageIsGreaterThan(double threePointPercentage);
}
