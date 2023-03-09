package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExemptionWasGranted(@JsonProperty("card_id") String cardId,
                                  @JsonProperty("fraction_type") String fractionType,
                                  @JsonProperty("weight") int weight,
                                  @JsonProperty("expiry_date") String expiryDate) implements Event {
}
