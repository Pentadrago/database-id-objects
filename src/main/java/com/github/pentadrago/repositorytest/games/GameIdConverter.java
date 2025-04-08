package com.github.pentadrago.repositorytest.games;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class GameIdConverter implements AttributeConverter<GameId, Long> {


    @Override
    public Long convertToDatabaseColumn(GameId gameId) {
        return gameId.getId();
    }

    @Override
    public GameId convertToEntityAttribute(Long id) {
        return new  GameId(id);
    }
}
