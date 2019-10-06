package football.service;

import football.FootballApplication;
import football.dto.PlayerWithTeamName;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {FootballApplication.class})
@QuickPerfTest
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @ExpectSelect(1)
    @Test
    public void should_find_all_players() {

        List<PlayerWithTeamName> playersWithTeamName = playerService.findPlayersWithTeamName();

        assertThat(playersWithTeamName).hasSize(2);

    }

}