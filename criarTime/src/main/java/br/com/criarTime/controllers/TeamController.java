package br.com.criarTime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criarTime.entity.TeamEntity;
import br.com.criarTime.services.TeamService;

@RestController
@RequestMapping("/times")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TeamController {
    
    @Autowired
    TeamService teamService;

    @GetMapping
    public List<TeamEntity> getAllTeams(){
        return teamService.getAllTeams();
    }
}
