package com.dddeurope.recycle;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class MainController {
    @GetMapping("/validate")
    public String validate() {
        return "Hi!";
    }

    @PostMapping("/handle-command")
    public String handle() {
        return toJson(
            record("type", "PriceWasCalculated"),
            record("created_at", LocalDateTime.now()),
            record("event_id", UUID.randomUUID()),
            record("payload", toJson(
                record("person_id", "Tom"),
                record("price_amount", BigDecimal.ZERO),
                record("price_currency", "EUR")
            ))
        );
    }

    private static String toJson(String... values) {
        return "{" + String.join(", ", values) + "}";
    }

    private static String record(String key, Object value) {
        return enquote(key) + ": " + enquote(value.toString());
    }

    private static String record(String key, BigDecimal value) {
        return enquote(key) + ": " + value;
    }

    private static String enquote(String value) {
        if (value.startsWith("{")) return value;
        return "\"" + value + "\"";
    }
}
