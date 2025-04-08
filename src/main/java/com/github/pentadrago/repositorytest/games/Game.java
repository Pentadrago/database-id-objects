package com.github.pentadrago.repositorytest.games;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Game {

    @Id
    @GeneratedValue(generator = "GameId")
    @GenericGenerator(name = "GameId", strategy = "com.github.pentadrago.repositorytest.games.GameIdGenerator")
    @Convert(converter = GameIdConverter.class)
    private GameId id;

    private String name;

    public GameId getId() {
        return id;
    }

    public void setId(GameId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
