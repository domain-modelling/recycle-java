package com.dddeurope.recycle.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.dddeurope.recycle.events.IdCardRegistered;
import com.dddeurope.recycle.events.IdCardScannedAtEntranceGate;
import com.dddeurope.recycle.events.IdCardScannedAtExitGate;
import org.junit.jupiter.api.Test;

class PriceCalculatorTest {
    @Test
    void visitWithoutDroppingWaste() {
        PriceCalculator calculator = new PriceCalculator(
            new IdCardRegistered("123", "John Doe", "an address", "a street"),
            new IdCardScannedAtEntranceGate("123", "2023-01-01"),
            new IdCardScannedAtExitGate("123")
        );

        assertThat(calculator.calculatePrice("123")).isEqualTo(0.0);
    }
}