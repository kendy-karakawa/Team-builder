package br.com.criarTime.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criarTime.entity.PlayerEntity;
import br.com.criarTime.services.PlayerService;

@RestController
@RequestMapping("/jogador")
@CrossOrigin(origins = {"https://team-builder-web.vercel.app"})
public class PlayerController {
    
    @Autowired
    PlayerService playerService;

    @PostMapping
    public void createPlayer(@RequestBody PlayerEntity player){
        playerService.createOrSelectTeamForThisPlayer(player);
    }

    @DeleteMapping("/all")
    public void deleteAll(){
        playerService.deleteAll();
    }
}
