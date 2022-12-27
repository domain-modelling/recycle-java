package com.dddeurope.recycle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceWasCalculated {
    @JsonProperty("person_id")
    public final String personId;

    @JsonProperty("price_amount")
    public final double amount;

    @JsonProperty("price_currency")
    public final String currency;

    public PriceWasCalculated(String personId, double amount, String currency) {
        this.personId = personId;
        this.amount = amount;
        this.currency = currency;
    }
}
