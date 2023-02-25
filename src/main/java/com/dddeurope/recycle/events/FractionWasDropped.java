package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FractionWasDropped(@JsonProperty("card_id") String cardId,
                                 @JsonProperty("fraction_type") String fractionType,
                                 @JsonProperty("weight") int weight) implements Event {
}
