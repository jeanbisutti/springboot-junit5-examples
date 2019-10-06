package football.controller;

import football.dto.PlayerWithTeamName;
import football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<PlayerWithTeamName> findAll() {
        return playerService.findPlayersWithTeamName();
    }

}
