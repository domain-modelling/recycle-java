package com.dddeurope.recycle.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PriceWasCalculated(
    @JsonProperty("card_id") String cardId,
    @JsonProperty("price_amount") double amount,
    @JsonProperty("price_currency") String currency
) implements Event { }
