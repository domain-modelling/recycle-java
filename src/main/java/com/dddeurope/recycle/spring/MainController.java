package com.dddeurope.recycle.spring;

import static com.dddeurope.recycle.commands.CommandParser.parse;

import com.dddeurope.recycle.events.Event;
import com.dddeurope.recycle.events.EventParser;
import com.dddeurope.recycle.events.PriceWasCalculated;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    private final ObjectMapper mapper;

    public MainController() {
        mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
    }

    @GetMapping("/validate")
    public String validate() {
        return "Hi!";
    }

    @PostMapping("/handle-command")
    public String handle(@RequestBody RecycleRequest request) {
        request.history.stream()
            .map(EventParser::parse)
            .forEach(System.out::println);
        System.out.println(parse(request.command));

        try {
            return mapper.writeValueAsString(
                new Event<>(new PriceWasCalculated("123", 0.0, "EUR"))
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static class RecycleRequest {
        public List<String> history = new ArrayList<>();
        public String command = "";

        @Override
        public String toString() {
            return "Request{" +
                "history=" + history +
                ", command='" + command + '\'' +
                '}';
        }
    }

}
