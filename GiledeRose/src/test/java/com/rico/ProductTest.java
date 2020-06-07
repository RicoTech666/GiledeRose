package com.rico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    private Product product;

    @BeforeEach
    public void prepare_product() {
        int sellIn = 5;
        double quality = 10.0;
        product = new Product(sellIn, quality);
    }

    @Test
    public void should_return_correct_sellIn_and_quality_when_not_expire() {
        product.qualityChangeByDay(5);
        assertEquals(5.0,product.getQuality());
        assertEquals(0,product.getSellIn());
    }

    @Test
    public void should_return_correct_sellIn_and_quality_when_expire() {
        product.qualityChangeByDay(6);
        assertEquals(3.0,product.getQuality());
        assertEquals(-1,product.getSellIn());
    }


}
