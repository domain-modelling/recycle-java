package com.dddeurope.recycle.commands;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class CalculatePrice implements Command {
    @JsonProperty("card_id")
    private  String cardId;

    public CalculatePrice() {
    }

    public CalculatePrice(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CalculatePrice) obj;
        return Objects.equals(this.cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId);
    }

    @Override
    public String toString() {
        return "CalculatePrice[" +
                "cardId=" + cardId + ']';
    }

}
