package br.com.criarTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.criarTime.entity.PlayerEntity;
import br.com.criarTime.entity.TeamEntity;
import br.com.criarTime.repositories.PlayerRepository;
import br.com.criarTime.repositories.TeamRepository;
import br.com.criarTime.services.PlayerService;
import br.com.criarTime.services.TeamService;

@SpringBootTest
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private TeamService teamService;

    @Mock
    private TeamRepository teamRepository;
    
    @Test
    public void testCreateOrSelectTeamForThisPlayerScenario1() {
        //Scenario 1: Team does not exist
        PlayerEntity player = new PlayerEntity();
        player.setNome("John Doe");
        
        when(teamService.getTeamByName("D")).thenReturn(null);
        playerService.createOrSelectTeamForThisPlayer(player);
        verify(teamService, times(1)).createTeam("D");
        verify(playerRepository, times(1)).save(any(PlayerEntity.class));
    }

    @Test
    public void testCreateOrSelectTeamForThisPlayerScenario2(){
        // Scenario 2: Team exists, but player with the same last name does not exist
        PlayerEntity existePlayer = new PlayerEntity();
        existePlayer.setNome("Thi Donald");
        
        List<PlayerEntity> players = new ArrayList<>();
        players.add(existePlayer);

        TeamEntity team = new TeamEntity();
        team.setName("D");
        team.setPlayers(players);

        PlayerEntity player = new PlayerEntity();
        player.setNome("John Doe");

        when(teamService.getTeamByName("D")).thenReturn(team);
        playerService.createOrSelectTeamForThisPlayer(player);
        verify(playerRepository, times(1)).save(any(PlayerEntity.class));
    }

    @Test
    public void testCreateOrSelectTeamForThisPlayerScenario3(){
        // Scenario 3: Team exists, and player with the same last name exists
        PlayerEntity existePlayer = new PlayerEntity();
        existePlayer.setNome("Thi doe");
        
        List<PlayerEntity> players = new ArrayList<>();
        players.add(existePlayer);

        TeamEntity team = new TeamEntity();
        team.setName("D");
        team.setPlayers(players);

        PlayerEntity player = new PlayerEntity();
        player.setNome("John Doe");

        when(teamService.getTeamByName("D")).thenReturn(team);
        when(teamService.getTeamByName("D")).thenReturn(null);

        playerService.createOrSelectTeamForThisPlayer(player);
        verify(teamService, times(1)).createTeam("D");
        verify(playerRepository, times(1)).save(any(PlayerEntity.class));
    }

    @Test
    public void testCreatePlayer() {
        TeamEntity team = new TeamEntity();
        team.setName("Team1");

        playerService.createPlayer("John Doe", team);
        verify(playerRepository, times(1)).save(any(PlayerEntity.class));
    }

    @Test
    public void testDeleteAll() {
        playerService.deleteAll();
        verify(playerRepository, times(1)).deleteAll();
        verify(teamRepository, times(1)).deleteAll();
    }
}
