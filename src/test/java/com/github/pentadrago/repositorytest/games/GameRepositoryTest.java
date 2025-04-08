package com.github.pentadrago.repositorytest.games;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class GameRepositoryTest {

    @Autowired
    private GameRepository testSubject;

    @Test
    @DirtiesContext
    void findsGame() {

        Game game = new Game();
        game.setName("Brütal Legend");

        testSubject.save(game);

        Optional<Game> foundGame = testSubject.findByName("Brütal Legend");

        assertThat(foundGame).get().extracting(Game::getId).isEqualTo(new GameId(1L));
    }

    @Test
    @DirtiesContext
    void findsGame2() {

        Game game = new Game();
        game.setName("Brütal Legend");

        testSubject.save(game);

        Game game2 = new Game();
        game2.setName("Atlas Fallen");

        testSubject.save(game2);

        testSubject.flush();

        game2.setName("Atlas Fallen - Reign of Sand");
        testSubject.save(game2);

        Optional<Game> foundGame = testSubject.findByName("Atlas Fallen - Reign of Sand");

        assertThat(foundGame).get().extracting(Game::getId).isEqualTo(new GameId(2L));
    }

    @Test
    @DirtiesContext
    void findsGame2ById() {

        Game game = new Game();
        game.setName("Brütal Legend");

        testSubject.save(game);

        Game game2 = new Game();
        game2.setName("Atlas Fallen");

        testSubject.save(game2);

        testSubject.flush();

        game2.setName("Atlas Fallen - Reign of Sand");
        testSubject.save(game2);

        Game foundGame = testSubject.getReferenceById(new GameId(2L));

        assertThat(foundGame).extracting(Game::getName).isEqualTo("Atlas Fallen - Reign of Sand");
    }


}