package br.com.criarTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.criarTime.entity.TeamEntity;
import br.com.criarTime.repositories.TeamRepository;
import br.com.criarTime.services.TeamService;

    @SpringBootTest
    public class TeamServiceTest {


    @InjectMocks
    private TeamService teamService;

    @Mock
    private TeamRepository teamRepository;

    @Test
    public void testGetTeamByName(){
        TeamEntity team = new TeamEntity();
        team.setName("Team1");
        when(teamRepository.findByName("Team1")).thenReturn(team);

        TeamEntity result = teamService.getTeamByName("Team1");
        assertEquals("Team1", result.getName());    
    }


    @Test
    public void testCreateTeam() {
        TeamEntity team = new TeamEntity();
        team.setName("Team1");
        when(teamRepository.save(team)).thenReturn(team);

        TeamEntity result = teamService.createTeam("Team1");
        assertEquals("Team1", result.getName());
    }

    @Test
    public void testFindTeamsAndPlayers() {
        List<Object[]> results = new ArrayList<>();
        results.add(new Object[] { "Team1", "Player1" });
        results.add(new Object[] { "Team1", "Player2" });
        when(teamRepository.findTeamsAndPlayers()).thenReturn(results);

        Map<String, List<String>> expected = new HashMap<>();
        expected.put("Team1", Arrays.asList("Player1", "Player2"));

        Map<String, List<String>> result = teamService.findTeamsAndPlayers();
        assertEquals(expected, result);
    }

}