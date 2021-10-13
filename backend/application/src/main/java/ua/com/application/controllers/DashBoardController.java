package ua.com.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.application.dto.ArticleAuthorDTO;
import ua.com.application.models.Article;
import ua.com.application.models.NBAPlayer;
import ua.com.application.services.ArticleService;
import ua.com.application.services.NBAPlayerService;
import ua.com.application.utils.comparators.NBAPlayerComparators;
import ua.com.application.utils.comparators.NBAPlayersComparatorMapUtil;
import ua.com.application.utils.comparators.PlayersSortUtil;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/dashboard")
@RestController
public class DashBoardController {
    private final NBAPlayerService playerService;
    @Autowired
    private PlayersSortUtil playersSortUtil;
    @Autowired
    private NBAPlayersComparatorMapUtil comparatorMapUtil;
    @Autowired
    private ArticleService articleService;

    public DashBoardController(NBAPlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<NBAPlayer>> showDashBoard() {
        return ResponseEntity.of(Optional.of(playerService.findAllPlayers().stream()
                .sorted(NBAPlayerComparators.OVERALL_SCORING_PERCENTAGE).collect(Collectors.toList())));
    }

    @GetMapping("/highest-points-per-game")
    public List<NBAPlayer> mostPointsPerGame() {
        return playerService.findAllPlayers().stream()
                .sorted(NBAPlayerComparators.OVERALL_SCORING_PERCENTAGE).collect(Collectors.toList());
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<NBAPlayer>> getPlayersSorted(@RequestParam String param) {
        return ResponseEntity.of(Optional.of(playersSortUtil.sortPlayersByParam(playerService.findAllPlayers(), param)));
    }

    @GetMapping("/comparators")
    public ResponseEntity<List<NBAPlayer>> getPlayersCompared(@RequestParam List<String> params) {
        return ResponseEntity.ok(playerService.getPlayersComparedByParams(params));
    }

    @GetMapping("/comparators-names")
    public Set<String> getComparatorsNames() {
        return comparatorMapUtil.getNbaPlayerComparatorsMap().keySet();
    }

    @GetMapping("/get-all-articles")
    public List<ArticleAuthorDTO> getAllArticlesDTO() {
        return articleService.getAllArticlesDTO();
    }

    @PostMapping("/save-article")
    public Article saveArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }
}
