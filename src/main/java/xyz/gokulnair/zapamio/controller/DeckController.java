package xyz.gokulnair.zapamio.controller;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.gokulnair.zapamio.domain.Deck;
import xyz.gokulnair.zapamio.dto.request.DeckRequest;
import xyz.gokulnair.zapamio.dto.response.DeckResponse;
import xyz.gokulnair.zapamio.service.DeckService;

@RestController
@RequestMapping("/api/decks")
public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }


    @PostMapping
    public Mono<Deck> createDeck(@RequestBody DeckRequest deckRequest){
        return deckService.createDeck(deckRequest.getTitle(),deckRequest.getDescription());
    }

    @GetMapping
    public Flux<DeckResponse> getAllDecks(){
        return deckService.listDecks();
    }
}
