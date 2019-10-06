package football.controller;

import football.FootballApplication;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {FootballApplication.class})
@AutoConfigureMockMvc
@QuickPerfTest
public class PlayerControllerWithMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @ExpectSelect(1)
    @Test
    public void should_find_all_players() throws Exception {
        mockMvc.perform(get("/players"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Pogba")))
               .andExpect(content().string(containsString("Griezmann")));
    }

}