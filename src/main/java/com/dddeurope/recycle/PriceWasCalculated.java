package com.dddeurope.recycle;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PriceWasCalculated(
    @JsonProperty("person_id") String personId,
    @JsonProperty("price_amount") double amount,
    @JsonProperty("price_currency") String currency
) { }
