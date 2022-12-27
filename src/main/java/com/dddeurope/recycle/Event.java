package com.dddeurope.recycle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class Event<TPayload> {
    @JsonProperty("type")
    public final String type;

    @JsonProperty("event_id")
    public final String eventId;

    @JsonProperty("created_at")
    public final LocalDateTime createdAt;

    @JsonProperty("payload")
    public final TPayload payload;

    public Event(TPayload payload) {
        this.type = payload.getClass().getSimpleName();
        this.eventId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.payload = payload;
    }
}
