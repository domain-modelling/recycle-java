package com.dddeurope.recycle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PriceWasCalculated {
    @JsonProperty("person_id")
    public final String personId;

    @JsonProperty("price_amount")
    public final BigDecimal amount;

    @JsonProperty("price_currency")
    public final String currency;

    public PriceWasCalculated(String personId, BigDecimal amount, String currency) {
        this.personId = personId;
        this.amount = amount;
        this.currency = currency;
    }
}
