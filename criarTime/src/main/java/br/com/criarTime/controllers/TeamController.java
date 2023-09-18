package br.com.criarTime.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criarTime.services.TeamService;

@RestController
@RequestMapping("/times")
@CrossOrigin(origins = {"https://team-builder-web.vercel.app"})
public class TeamController {
    
    @Autowired
    TeamService teamService;

    @GetMapping
    public Map<String, List<String>> findTeamsAndPlayers(){
        return teamService.findTeamsAndPlayers();
    }
}
