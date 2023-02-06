package com.dddeurope.recycle;

import static org.assertj.core.api.Assertions.assertThat;

import com.dddeurope.recycle.commands.CalculatePrice;
import com.dddeurope.recycle.commands.CommandParser;
import org.junit.jupiter.api.Test;

public class CommandMappingTest {
    @Test
    void parseCommand() {
        String commandText =
            "{\"command_id\":\"TODO\",\"created_at\":\"2023-02-06T13:35:37.124681Z\",\"payload\":{\"card_id\":\"123\"},\"type\":\"CalculatePrice\"}";

        assertThat(CommandParser.parse(commandText)).isEqualTo(new CalculatePrice("123"));
    }
}