package de.samuelgesang.restclientexercise.characters;

import de.samuelgesang.restclientexercise.characters.api.RickMortyApiCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final RickMortyApiService rickMortyApiService;

    public CharacterController(RickMortyApiService rickMortyApiService) {
        this.rickMortyApiService = rickMortyApiService;
    }

    @GetMapping
    public List<RickMortyApiCharacter> getAllCharacters(@RequestParam(required = false) String status) {
        return rickMortyApiService.loadAllCharacters().stream().filter(character -> status == null || character.status().equals(status)).toList();
    }
}
