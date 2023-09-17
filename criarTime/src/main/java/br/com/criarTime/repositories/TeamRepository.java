package br.com.criarTime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.criarTime.entity.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
    TeamEntity findByName(String name);
}
