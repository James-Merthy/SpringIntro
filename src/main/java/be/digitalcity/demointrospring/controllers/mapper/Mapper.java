package be.digitalcity.demointrospring.controllers.mapper;

import be.digitalcity.demointrospring.controllers.dto.PlayerDTO;
import be.digitalcity.demointrospring.controllers.entities.Player;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class Mapper {

    public PlayerDTO toPlayersDto(Player entity){


        return PlayerDTO.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .age(entity.getNumber())
                .birthdate(entity.getBirthdate())
                .name(entity.getName())
                .poste(entity.getPoste())
                .salaire(entity.getSalaire())
                .age(Period.between(LocalDate.now(),entity.getBirthdate()).getYears())
                .build() ;
    }

    public Player toPlayerEntity(PlayerDTO oto){

        return null ;
    }


}
