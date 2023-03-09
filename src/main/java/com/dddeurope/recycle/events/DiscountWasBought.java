package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DiscountWasBought(@JsonProperty("card_id") String cardId,
                                @JsonProperty("discount_percentage") float discountPercentage,
                                @JsonProperty("fraction_type") String fractionType,
                                @JsonProperty("weight") int weight,
                                @JsonProperty("expiry_date") String expiryDate) implements Event {
}
