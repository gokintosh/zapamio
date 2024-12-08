package xyz.gokulnair.zapamio.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.gokulnair.zapamio.domain.Deck;
import xyz.gokulnair.zapamio.dto.response.DeckResponse;
import xyz.gokulnair.zapamio.repository.DeckRepository;

import java.time.Instant;
import java.util.UUID;

@Service
public class DeckService {

    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Mono<Deck> createDeck(String title,String description){
        Deck deck=new Deck();
        deck.setTitle(title);
        deck.setDescription(description);
        deck.setCreatedAt(Instant.now());
        deck.setUpdatedAt(Instant.now());


        return deckRepository.save(deck);

    }

//    public Mono<Deck> updateDeck(UUID deckId){
//        Mono<Deck> deckToUpDate = deckRepository.findById(deckId);
//
//    }

    public Flux<DeckResponse> listDecks(){
        return deckRepository.findAll()
                .map(deck-> new DeckResponse(deck.getTitle(),deck.getDescription(),deck.getCreatedAt(),deck.getUpdatedAt()));
    }
}
