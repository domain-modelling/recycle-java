package com.dddeurope.recycle.events;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventParser {
    public static Event parse(String eventText) {
        try {
            JSONObject event = new JSONObject(eventText);
            String eventType = event.getString("type");
            JSONObject payload = event.getJSONObject("payload");
            if ("IdCardRegistered".equals(eventType)) {
                return new Event<>(eventId(event), createdAt(event), idCardRegistered(payload));
            }
            return new Event<>(eventType, eventId(event), createdAt(event), payload.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static String eventId(JSONObject event) {
        return event.getString("event_id");
    }

    private static LocalDateTime createdAt(JSONObject event) {
        return LocalDateTime.parse(
            event.getString("created_at"),
            DateTimeFormatter.ISO_DATE_TIME);
    }

    private static Object idCardRegistered(JSONObject payload) {
        return new IdCardRegistered(
            payload.getString("card_id"),
            payload.getString("person_id"),
            payload.getString("address"),
            payload.getString("city")
        );
    }
}
