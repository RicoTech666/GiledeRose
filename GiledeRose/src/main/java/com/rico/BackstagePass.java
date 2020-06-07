package com.rico;

public class BackstagePass extends Product {

    public BackstagePass(int sellIn, double quality) {
        super(sellIn, quality);
    }

    @Override
    void updateQualityAndSellInBeforeExpire(int dayCount) {
        this.sellIn -= dayCount;
        if (dayCount > 10) {
            this.quality += dayCount - 10;
            dayCount = 10;
        }
        if (dayCount > 5 && dayCount <= 10) {
            this.quality += (dayCount - 5) * 2;
            dayCount = 5;
        }
        if (dayCount > 0 && dayCount <= 5) {
            this.quality += dayCount * 3;
        }
        checkQualityMax();
    }

    @Override
    void updateQualityAndSellInAfterExpire(int dayCount) {
        if (this.sellIn > 0) {
            dayCount -= this.sellIn;
            updateQualityAndSellInBeforeExpire(this.sellIn);
        }
        this.quality = 0;
        this.sellIn -= dayCount;
    }

    private void checkQualityMax() {
        if (quality > 50) {
            quality = 50;
        }
    }
}
