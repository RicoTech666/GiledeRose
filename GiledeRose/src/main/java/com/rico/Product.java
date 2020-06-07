package com.rico;

class Product {

    protected int sellIn;
    protected double quality;

    public Product(int sellIn, double quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public double getQuality() {
        return quality;
    }

    public void qualityChangeByDay(int dayCount) {
        if (dayCount <= this.sellIn) {
            updateQualityAndSellInBeforeExpire(dayCount);
        } else {
            updateQualityAndSellInAfterExpire(dayCount);
        }
    }

    void updateQualityAndSellInBeforeExpire(int dayCount) {
        double estimatedQuality = this.quality - dayCount;
        this.quality = estimatedQuality >= 0 ? estimatedQuality : 0;
        this.sellIn -= dayCount;
    }

    void updateQualityAndSellInAfterExpire(int dayCount) {
        if (this.sellIn > 0) {
            dayCount -= this.sellIn;
            updateQualityAndSellInBeforeExpire(this.sellIn);
        }
        double estimatedQuality = this.quality - dayCount * 2;
        this.quality = estimatedQuality >= 0 ? estimatedQuality : 0;
        this.sellIn -= dayCount;
    }
}
