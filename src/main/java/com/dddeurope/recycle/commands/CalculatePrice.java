package com.dddeurope.recycle.commands;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CalculatePrice (@JsonProperty("card_id") String cardId) implements Command { }
