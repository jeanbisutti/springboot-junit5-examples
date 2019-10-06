package football.service;

import football.dto.PlayerWithTeamName;
import football.entity.Player;
import football.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional(readOnly = true)
    public List<PlayerWithTeamName> findPlayersWithTeamName() {
        List<Player> players = playerRepository.findAll();
        return  players
               .stream()
               .map(player -> new PlayerWithTeamName(
                                    player.getFirstName()
                                  , player.getLastName()
                                  , player.getTeam().getName()
                              )
                    )
               .collect(Collectors.toList());
    }

}
