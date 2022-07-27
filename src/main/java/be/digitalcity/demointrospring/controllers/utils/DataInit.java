package be.digitalcity.demointrospring.controllers.utils;

import be.digitalcity.demointrospring.controllers.entities.Player;
import be.digitalcity.demointrospring.controllers.service.PlayerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final PlayerService playerService ;

    private List<Player> players = Arrays.asList(
      Player.builder()
              .name("Hazard")
              .birthdate(LocalDate.of(1995,11,2))
              .number(17)
              .salaire(500000)
              .poste(Poste.AVANT_GAUCHE)
              .build(),
            Player.builder()
            .name("DeBruyene")
            .birthdate(LocalDate.of(1995,11,2))
            .number(10)
            .salaire(90000000)
            .poste(Poste.MILIEUX_CENTRALE)
              .build(),
                    Player.builder()
            .name("modric")
            .birthdate(LocalDate.of(1995,11,2))
            .number(11)
            .salaire(80000000)
            .poste(Poste.MILIEUX_DEFFENSIF)

              .build() ,
            Player.builder()
                    .name("messi")
                    .birthdate(LocalDate.of(1995,11,2))
                    .number(30)
                    .salaire(1000000000)
                    .poste(Poste.ATTAQUANT)
                    .build(),
            Player.builder()
                    .name("muller")
                    .birthdate(LocalDate.of(1995,11,2))
                    .number(14)
                    .salaire(85000000)
                    .poste(Poste.MILIEU_OFFENSIVE)
                    .build(),
            Player.builder()
                    .name("Coman")
                    .birthdate(LocalDate.of(1995,11,2))
                    .number(7)
                    .salaire(350000000)
                    .poste(Poste.AVANT_GAUCHE)

                    .build()


    );

    public DataInit(PlayerService playerService) {
        this.playerService = playerService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        this.players.forEach(playerService::insert);
    }
}
