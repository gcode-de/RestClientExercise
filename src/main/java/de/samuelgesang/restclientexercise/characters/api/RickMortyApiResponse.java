package de.samuelgesang.restclientexercise.characters.api;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record RickMortyApiResponse(
        @JsonAlias("info")
        RickMortyApiInfo infos,
        List<RickMortyApiCharacter> results
) {
}
