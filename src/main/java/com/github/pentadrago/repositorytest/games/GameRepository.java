package com.github.pentadrago.repositorytest.games;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, GameId> {

    Optional<Game> findByName(String name);

}
