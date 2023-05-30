package com.dddeurope.recycle.domain;

import com.dddeurope.recycle.events.Event;
import com.dddeurope.recycle.events.FractionWasDropped;
import com.dddeurope.recycle.events.IdCardRegistered;
import com.dddeurope.recycle.events.IdCardScannedAtEntranceGate;
import com.dddeurope.recycle.events.IdCardScannedAtExitGate;

import java.util.Arrays;
import java.util.List;

public class PriceCalculator {
    public PriceCalculator(Event... events) {
        this(Arrays.stream(events).toList());
    }

    public PriceCalculator(List<Event> events) {
        for (Event event : events) handle(event);
    }

    private void handle(Event event) {
        if (event instanceof IdCardRegistered cardRegistered) {
            // do something with cardRegistered
        }
        if (event instanceof IdCardScannedAtEntranceGate cardScanned) {
            // do something with cardScanned
        }
        if (event instanceof FractionWasDropped fractionDropped) {
            // do something with fractionDropped
        }
        if (event instanceof IdCardScannedAtExitGate cardScanned) {
            // do something with cardRegistered
        }
    }

    public double calculatePrice(String cardId) {
        return 0;
    }
}
