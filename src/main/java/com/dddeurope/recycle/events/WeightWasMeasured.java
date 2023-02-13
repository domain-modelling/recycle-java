package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeightWasMeasured(@JsonProperty("card_id") String cardId,
                                @JsonProperty("weight") int weight) implements Event {
}
