package br.com.criarTime.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.criarTime.entity.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
    TeamEntity findByName(String name);

    @Query("SELECT t.name as teamName, p.nome as playerName FROM TeamEntity t JOIN t.players p")
    List<Object[]> findTeamsAndPlayers();


}
