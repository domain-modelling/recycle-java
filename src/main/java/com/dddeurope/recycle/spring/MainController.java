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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/validate")
    public String validate() {
        return "Hi!";
    }

    @PostMapping("/handle-command")
    public ResponseEntity<EventMessage> handle(@RequestBody RecycleRequest request) {
        LOGGER.info("Incoming Request: {}", request.asString());

        var message = new EventMessage("todo", new PriceWasCalculated("321", 0, "EUR"));

        return ResponseEntity.ok(message);
    }

    public record RecycleRequest(List<EventMessage> history, CommandMessage command) {

        public String asString() {
            var historyAsString = history.stream()
                    .map(EventMessage::toString)
                    .collect(Collectors.joining("\n\t"));

            return String.format("%n%s %nWith History\n\t%s", command, historyAsString);
        }

    }

}
