package com.dddeurope.recycle.spring;

import com.dddeurope.recycle.commands.CommandMessage;
import com.dddeurope.recycle.events.EventMessage;
import com.dddeurope.recycle.events.PriceWasCalculated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/validate")
    public String validate() {
        return "Hi!";
    }

    @PostMapping("/handle-command")
    public ResponseEntity<EventMessage> handle(@RequestBody RecycleRequest request) {
        LOGGER.info("Incoming Command: {}", request.asString());


        var message = new EventMessage();
        message.setType("PriceWasCalculated");
        message.setEventId("123");
        message.setCreatedAt(LocalDateTime.now());
        message.setPayload(new PriceWasCalculated("123", 0.0, "EUR"));

        return ResponseEntity.ok(message);
    }

    public record RecycleRequest(List<EventMessage> history, CommandMessage command) {

        public String asString() {
            return String.format("\n%s \nWith History\n\t\t%s", command, String.join("\n\t\t", history.stream().map(EventMessage::toString).toList()));
        }

    }

}
