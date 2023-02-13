package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FractionWasSelected(@JsonProperty("card_id") String cardId,
                                  @JsonProperty("fraction_type") String fractionType) implements Event {
}
