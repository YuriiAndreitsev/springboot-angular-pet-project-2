package ua.com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.application.models.NBAPlayer;
import ua.com.application.models.Player;
import ua.com.application.models.Team;
import ua.com.application.services.NBAPlayerService;

import java.util.Random;

@SpringBootApplication
public class Application {
//    @Autowired
//    NBAPlayerService service;
//    Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//
//    @Bean
//    ApplicationRunner thisWillRunAutomatically() {
//        return args -> {
//            service.addNBAPlayer(randomizePlayer("Killian Hayes"));
//            service.addNBAPlayer(randomizePlayer("Cade Cunningham"));
//            service.addNBAPlayer(randomizePlayer("Jerami Grant"));
//            service.addNBAPlayer(randomizePlayer("Kelly Olynyk"));
//            service.addNBAPlayer(randomizePlayer("Isaiah Stewart"));
//            service.addNBAPlayer(randomizePlayer("Josh Jackson"));
//            service.addNBAPlayer(randomizePlayer("Cory Joseph"));
//            service.addNBAPlayer(randomizePlayer("Frank Jackson"));
//            service.addNBAPlayer(randomizePlayer("Trey Lyles"));
//
//        };
//    }
//
//    private double getRandom(Random random, double rangeMin, double rangeMax) {
//        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
//    }
//
//    private NBAPlayer randomizePlayer(String name) {
//        return new NBAPlayer(null, name,
//                Team.DETROIT_PISTONS,
//                getRandom(random, 10, 25),
//                new Random().nextInt(83),
//                getRandom(random, 20, 35),
//                getRandom(random, 25, 40),
//                getRandom(random, 2, 18),
//                getRandom(random, 1, 9)
//        );
//    }
}
