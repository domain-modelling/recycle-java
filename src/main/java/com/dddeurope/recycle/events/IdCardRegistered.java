package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IdCardRegistered(@JsonProperty("card_id") String cardId,
                               @JsonProperty("person_id") String personId,
                               @JsonProperty("address") String address,
                               @JsonProperty("city") String city) implements Event {
}
