package br.com.criarTime.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criarTime.entity.TeamEntity;
import br.com.criarTime.repositories.TeamRepository;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public TeamEntity getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    public TeamEntity createTeam(String name) {
        TeamEntity team = new TeamEntity();
        team.setName(name);
        return teamRepository.save(team);
    }

    public Map<String, List<String>> findTeamsAndPlayers() {
        List<Object[]> results = teamRepository.findTeamsAndPlayers();
        Map<String, List<String>> teams = new HashMap<>();

        for (Object[] result : results) {
            String teamName = (String) result[0];
            String playerName = (String) result[1];

            if (!teams.containsKey(teamName)) {
                teams.put(teamName, new ArrayList<>());
            }
        teams.get(teamName).add(playerName);
        }

        return teams;
    }
}
