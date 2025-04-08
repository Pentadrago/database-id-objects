package com.github.pentadrago.repositorytest.games;

import java.io.Serializable;
import java.util.Objects;

public class GameId implements Serializable {

    final Long id;

    public GameId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameId gameId = (GameId) o;
        return id == gameId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
