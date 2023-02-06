package com.dddeurope.recycle.commands;

import org.json.JSONException;
import org.json.JSONObject;

public class CommandParser {
    public static CalculatePrice parse(String commandText) {
        try {
            String cardId = new JSONObject(commandText)
                .getJSONObject("payload")
                .getString("card_id");
            return new CalculatePrice(cardId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
