package xyz.gokulnair.zapamio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.gokulnair.zapamio.domain.Card;
import xyz.gokulnair.zapamio.repository.CardRepository;

import java.time.Instant;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Mono<Card> createCard(UUID deckId, String word, String meaning){
        Card card=new Card();
        card.setId(UUID.randomUUID());
        card.setDeckId(deckId);
        card.setMeaning(meaning);
        card.setWord(word);
        card.setCreatedAt(Instant.now());
        card.setUpdatedAt(Instant.now());
        card.setDifficultyRating(3);

        return cardRepository.save(card);
    }

    public Flux<Card> findCardsFromDeck(UUID deckId){
        return cardRepository.findCardUsingDeck(deckId);
    }
}
