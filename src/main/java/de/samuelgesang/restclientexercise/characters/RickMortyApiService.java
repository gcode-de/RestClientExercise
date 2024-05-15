package de.samuelgesang.restclientexercise.characters;

import de.samuelgesang.restclientexercise.characters.api.RickMortyApiCharacter;
import de.samuelgesang.restclientexercise.characters.api.RickMortyApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickMortyApiService {

    private final RestClient restClient;

    public RickMortyApiService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://rickandmortyapi.com")
                .build();
    }

    public List<RickMortyApiCharacter> loadAllCharacters() {

        RickMortyApiResponse body = restClient.get()
                .uri("/api/character")
                .retrieve()
                .body(RickMortyApiResponse.class);

        assert body != null;
        return body.results();
    }
}