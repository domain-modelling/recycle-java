package com.dddeurope.recycle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MainController {

    private final ObjectMapper objectMapper;

    public MainController() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
    }

    @GetMapping("/validate")
    public String validate() {
        return "Hi!";
    }

    @PostMapping("/handle-command")
    public String handle() throws JsonProcessingException {
        Event<PriceWasCalculated> response = new Event<>(new PriceWasCalculated("Tom", BigDecimal.valueOf(0), "EUR"));
        return objectMapper.writeValueAsString(response);

//        return toJson(
//            record("type", "PriceWasCalculated"),
//            record("created_at", LocalDateTime.now()),
//            record("event_id", UUID.randomUUID()),
//            record("payload", toJson(
//                record("person_id", "Tom"),
//                record("price_amount", BigDecimal.ZERO),
//                record("price_currency", "EUR")
//            ))
//        );
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
