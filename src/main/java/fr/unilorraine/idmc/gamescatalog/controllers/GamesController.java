package fr.unilorraine.idmc.gamescatalog.controllers;
import fr.unilorraine.idmc.gamescatalog.dto.GameView;
import fr.unilorraine.idmc.gamescatalog.dto.NewGame;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("games")
@RequiredArgsConstructor
// https://spring.io/guides/gs/rest-service-cors/
@CrossOrigin(origins = {"*", "localhost", "google.com"})
public class GamesController {

    private final GamesService gamesService;

    @GetMapping
    public Iterable<GameView> findAll() {
        return gamesService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameView create(@RequestBody NewGame gg){
        return gamesService.create(gg);
    }


}
