package br.com.criarTime.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criarTime.entity.PlayerEntity;
import br.com.criarTime.entity.TeamEntity;
import br.com.criarTime.repositories.PlayerRepository;
import br.com.criarTime.repositories.TeamRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamService teamService;

    public void createOrSelectTeamForThisPlayer(PlayerEntity player) {
        String name = player.getNome();
        if(name == null) return;
        String[] fullName = name.split(" ");
        String lastName = fullName[fullName.length - 1];

        for (int i = 0; i < lastName.length(); i++) {
            String initialsOfName = lastName.substring(0, i + 1).toUpperCase();
            TeamEntity team = teamService.getTeamByName(initialsOfName);
            if (team == null) {
                TeamEntity saveTeam = teamService.createTeam(initialsOfName);
                createPlayer(name, saveTeam);
                return;
            } else {
                List<PlayerEntity> players = team.getPlayers();
                List<String> lastNamesOfPlayers = new ArrayList<>();
                for (PlayerEntity p : players) {
                    String pName = p.getNome();
                    String[] playerName = pName.split(" ");
                    lastNamesOfPlayers.add(playerName[playerName.length - 1]);
                }

                if (lastNamesOfPlayers.contains(lastName)) {
                    createPlayer(name, team);
                    return;
                }
            }
        }

    }

    public void createPlayer(String name, TeamEntity team) {
        PlayerEntity player = new PlayerEntity();
        player.setNome(name);
        player.setTeam(team);
        playerRepository.save(player);
    }

    public void deleteAll() {
        playerRepository.deleteAll();
        teamRepository.deleteAll();
    }
}
