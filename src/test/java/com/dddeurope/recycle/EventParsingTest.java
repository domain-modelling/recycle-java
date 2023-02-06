package com.dddeurope.recycle;

import static org.assertj.core.api.Assertions.assertThat;

import com.dddeurope.recycle.events.Event;
import com.dddeurope.recycle.events.EventParser;
import com.dddeurope.recycle.events.IdCardRegistered;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class EventParsingTest {
    @Test
    void mapIdCardRegistered() {
        String eventText =
            "{\"created_at\":\"2023-02-06T13:35:37.124640Z\",\"event_id\":\"todo\",\"payload\":{\"address\":\"1428 Elm Street\",\"card_id\":\"123\",\"city\":\"Moon Village\",\"person_id\":\"Freddy\"},\"type\":\"IdCardRegistered\"}";
        assertThat(EventParser.parse(eventText)).isEqualTo(new Event<>(
            "todo",
            LocalDateTime.parse("2023-02-06T13:35:37.124640"),
            new IdCardRegistered(
                "123",
                "Freddy",
                "1428 Elm Street",
                "Moon Village"
            )));
    }
}
