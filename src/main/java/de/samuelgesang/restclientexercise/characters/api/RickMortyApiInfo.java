package de.samuelgesang.restclientexercise.characters.api;

public record RickMortyApiInfo(
        int count,
        int pages,
        String next,
        String prev
) {
}
