package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IdCardScannedAtEntranceGate(@JsonProperty("card_id") String cardId, @JsonProperty("date") String date) implements Event {
}
