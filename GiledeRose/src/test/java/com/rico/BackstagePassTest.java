package com.rico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassTest {
    private BackstagePass backstagePass;

    @BeforeEach
    void setBackstageTest() {
        int sellIn = 11;
        double quality = 25;
        backstagePass = new BackstagePass(sellIn,quality);
    }

    @Test
    void should_return_correct_sellIn_and_quality_when_within_5_days() {
        backstagePass.qualityChangeByDay(1);
        assertEquals(28.0, backstagePass.getQuality());
        assertEquals(10,backstagePass.getSellIn());
    }

    @Test
    void should_return_correct_sellIn_and_quality_when_within_10_days() {
        backstagePass.qualityChangeByDay(6);
        assertEquals(42.0, backstagePass.getQuality());
        assertEquals(5,backstagePass.getSellIn());
    }

    @Test
    void should_return_correct_sellIn_and_quality_when_more_than_10_days() {
        backstagePass.qualityChangeByDay(11);
        assertEquals(50.0, backstagePass.getQuality());
        assertEquals(0,backstagePass.getSellIn());
    }

    @Test
    void should_return_correct_sellIn_and_quality_when_expire() {
        backstagePass.qualityChangeByDay(12);
        assertEquals(0, backstagePass.getQuality());
        assertEquals(-1,backstagePass.getSellIn());
    }
}