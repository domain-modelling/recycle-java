package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;
import java.util.Objects;

public final class EventMessage {

    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("type")
    private String type;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = IdCardRegistered.class, name = "IdCardRegistered"),
            @JsonSubTypes.Type(value = PriceWasCalculated.class, name = "PriceWasCalculated"),
            @JsonSubTypes.Type(value = IdCardScannedAtEntranceGate.class, name = "IdCardScannedAtEntranceGate"),
            @JsonSubTypes.Type(value = WeightWasMeasured.class, name = "WeightWasMeasured"),
            @JsonSubTypes.Type(value = FractionWasSelected.class, name = "FractionWasSelected"),
            @JsonSubTypes.Type(value = FractionWasDropped.class, name = "FractionWasDropped"),
            @JsonSubTypes.Type(value = IdCardScannedAtExitGate.class, name = "IdCardScannedAtExitGate"),
    })
    private Event payload;

    public EventMessage() {
        // for deserialization
    }

    public EventMessage(String eventId, Event payload) {
        this.eventId = eventId;
        this.type = payload.getClass().getSimpleName();
        this.createdAt = LocalDateTime.now();
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Event getPayload() {
        return payload;
    }

    public void setPayload(Event payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EventMessage) obj;
        return Objects.equals(this.type, that.type) &&
                Objects.equals(this.eventId, that.eventId) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, eventId, createdAt, payload);
    }

    @Override
    public String toString() {
        return "Event[" +
                "type=" + type + ", " +
                "eventId=" + eventId + ", " +
                "createdAt=" + createdAt + ", " +
                "payload=" + payload + ']';
    }

}
