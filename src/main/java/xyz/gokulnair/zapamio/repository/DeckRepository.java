package xyz.gokulnair.zapamio.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import xyz.gokulnair.zapamio.domain.Deck;

import java.util.UUID;

public interface DeckRepository extends ReactiveCrudRepository<Deck, UUID> {
    @Query("SELECT * from decks where LOWER(title) LIKE LOWER(concat('%',:titlePart,'%'))")
    Flux<Deck> searchByTitle(String titlePart);
}
