package xyz.gokulnair.zapamio.dto.response;

import java.time.Instant;

public class DeckResponse {
    private String title;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public DeckResponse(String title, String description, Instant createAt, Instant updatedAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createAt;
        this.updatedAt = updatedAt;
    }
}
