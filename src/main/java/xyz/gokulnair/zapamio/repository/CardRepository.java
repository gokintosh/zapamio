package xyz.gokulnair.zapamio.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import xyz.gokulnair.zapamio.domain.Card;

import java.util.UUID;

public interface CardRepository extends ReactiveCrudRepository<Card, UUID> {
    @Query("SELECT * from cards where deckId = ':deckId'")
    Flux<Card> findCardUsingDeck(UUID deckId);
}
