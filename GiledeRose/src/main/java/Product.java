public class Product {

    private final int initSellIn;
    private int sellIn;
    private double quality;

    public Product(int initSellIn, int sellIn, double quality) {

        this.initSellIn = initSellIn;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void qualityChangeByDay(int dayCount) {
        if( dayCount <= this.sellIn ) {
            updateQualityAndSellInBeforeExpire(dayCount);
        } else {
            updateQualityAndSellInAfterExpire(dayCount);
        }
    }

    private void updateQualityAndSellInBeforeExpire(int dayCount) {
        double estimatedQuality = this.quality - dayCount;
        this.quality = estimatedQuality >= 0 ? estimatedQuality : 0;
        this.sellIn -= dayCount;
    }

    private void updateQualityAndSellInAfterExpire(int dayCount) {
        if( this.sellIn > 0) {
            updateQualityAndSellInBeforeExpire(this.sellIn);
            dayCount -= this.sellIn;
        }
        double estimatedQuality = this.quality - dayCount * 2;
        this.quality = estimatedQuality >= 0 ? estimatedQuality : 0;
        this.sellIn -= dayCount;
    }
}
