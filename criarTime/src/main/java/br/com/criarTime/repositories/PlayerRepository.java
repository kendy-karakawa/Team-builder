package br.com.criarTime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criarTime.entity.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    
}
