package xyz.gokulnair.zapamio.dto.request;

import lombok.Data;

public class DeckRequest {
    String title;
    String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
