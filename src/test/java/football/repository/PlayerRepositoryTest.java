package football.repository;

import football.QuickPerfPerBeanConfig;
import football.entity.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.quickperf.annotation.*;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.statements.SpringRepeat;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Import(QuickPerfPerBeanConfig.class)
@DataJpaTest()
@QuickPerfTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    //@FunctionalIteration // You can use @FunctionalIteration or @DisableQuickPerf
    // to disable QuickPerf features and focus on functional
    // behavior (not performance behavior) in a first step.
    // In a second step, you can remove @FunctionalIteration
    // or @DisableQuickPerf to evaluate some performance
    // properties.
    // We recommend to do one step at a time.
    // The test will fail because N+1 select is detected from
    // disableSameSelectTypesWithDifferentParams defined in QuickPerfConfiguration
    // class.
    @ExpectSelect(1)
    //@FunctionalIteration
    @Test
    public void should_find_all_players() {
        List<Player> players = playerRepository.findAll();
        assertThat(players).hasSize(2);
    }

}
