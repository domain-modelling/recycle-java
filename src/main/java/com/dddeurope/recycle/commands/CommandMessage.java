package com.dddeurope.recycle.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

public final class CommandMessage {
    @JsonProperty("command_id")
    private String commandId;
    @JsonProperty("created_at")
    private String createdAt;
    private String type;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = CalculatePrice.class, name = "CalculatePrice")
    })
    private Command payload;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Command getPayload() {
        return payload;
    }

    public void setPayload(Command payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CommandMessage) obj;
        return Objects.equals(this.commandId, that.commandId) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandId, createdAt, type, payload);
    }

    @Override
    public String toString() {
        return "CommandMessage[" +
                "commandId=" + commandId + ", " +
                "createdAt=" + createdAt + ", " +
                "type=" + type + ", " +
                "payload=" + payload + ']';
    }


}
