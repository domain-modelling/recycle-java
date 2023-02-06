package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record Event<TPayload>(
    @JsonProperty("type") String type,
    @JsonProperty("event_id") String eventId,
    @JsonProperty("created_at") LocalDateTime createdAt,
    @JsonProperty("payload") TPayload payload
) {
    public Event(TPayload payload) {
        this(
            payload.getClass().getSimpleName(),
            UUID.randomUUID().toString(),
            LocalDateTime.now(),
            payload
        );
    }
    public Event(String eventId, LocalDateTime createdAt, TPayload payload) {
        this(
            payload.getClass().getSimpleName(),
            eventId,
            createdAt,
            payload
        );
    }
}
