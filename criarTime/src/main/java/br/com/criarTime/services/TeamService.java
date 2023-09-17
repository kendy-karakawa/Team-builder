package br.com.criarTime.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criarTime.entity.TeamEntity;
import br.com.criarTime.repositories.TeamRepository;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;


    public TeamEntity getTeamByName(String name){
        return teamRepository.findByName(name);
    }

    public TeamEntity createTeam(String name){
        TeamEntity team = new TeamEntity();
        team.setName(name);
        return teamRepository.save(team);
    }

    public List<TeamEntity> getAllTeams(){
        return teamRepository.findAll();
    }
    
}
