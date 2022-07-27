package be.digitalcity.demointrospring.controllers.service;

import be.digitalcity.demointrospring.controllers.dto.PlayerDTO;
import be.digitalcity.demointrospring.controllers.entities.Player;
import be.digitalcity.demointrospring.controllers.mapper.Mapper;
import be.digitalcity.demointrospring.controllers.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService implements IService<Player, PlayerDTO, Long> {

    private final PlayerRepository playerRepository;

    private final Mapper mapper;

    public PlayerService(PlayerRepository playerRepository, Mapper mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }


    @Override
    public List<PlayerDTO> getAll() {
        return this.playerRepository
                .findAll()
                .stream()
                .map(mapper::toPlayersDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getById(Long id) {
        Optional<Player> reslut = this.playerRepository.findById(id);

        return reslut.map(this.mapper::toPlayersDto).orElse(null);
    }

    @Override
    public boolean update(Long id, Player entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public PlayerDTO insert(Player entity) {
        if (entity != null) {
            Player newPlayer = this.playerRepository.save(entity);
            return this.mapper.toPlayersDto(newPlayer);
        } else {
            throw new RuntimeException("Attention, problème de validité des données !");
        }

    }

}
