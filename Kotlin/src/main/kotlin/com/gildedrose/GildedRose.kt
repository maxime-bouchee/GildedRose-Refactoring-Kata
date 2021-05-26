package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private val AGED_BRIE = "Aged Brie"
    private val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"
    private val CONJURED = "Conjured"

    fun updateQuality() {
        for (i in items.indices) {

            when(items[i].name){
                AGED_BRIE -> updateQualityAgedBrie(items[i])
                BACKSTAGE -> updateQualityBackstage(items[i])
                SULFURAS -> updateQualitySulfuras(items[i])
                else -> {
                    decreaseItemQuality(items[i])
                    if(items[i].sellIn < 0){
                        decreaseItemQuality(items[i])
                    }
                }
            }

/*            if (isNotAgedBrie(items[i].name) && isNotBackstage(items[i].name)) {
                updateQualityWhenQualityGreaterThan0(items[i])
            } else {
                updateQualityWhenQualityLessThan50(items[i])
            }

            if (isNotSulfuras(items[i].name)) {
                decreaseItemSellIn(items[i])
            }
            updateQualityWhenSellInLessThanZero(items[i])*/
        }
    }

/*    private fun updateQualityWhenQualityGreaterThan0(item: Item) {
        if (item.quality > 0) {
            if (isNotSulfuras(item.name)) {
                decreaseItemQuality(item)
            }
        }
    }*/

    private fun updateQualityAgedBrie(item: Item){
        increaseItemQuality(item)
        decreaseItemSellIn(item)
        if(item.sellIn < 0){
            increaseItemQuality(item)
        }
    }

    private fun updateQualitySulfuras(item: Item){
        increaseItemQuality(item)
    }

    private fun updateQualityBackstage(item: Item){
        if(item.quality < 50){
            increaseItemQuality(item)
        }
        if(item.sellIn < 11){
            if(item.quality < 50){
                increaseItemQuality(item)
            }
        }
        if(item.sellIn < 6){
            if(item.quality < 50){
                increaseItemQuality(item)
            }
        }
        decreaseItemSellIn(item)
        if(item.sellIn < 0){
            item.quality = 0
        }
    }

/*    private fun updateQualityWhenQualityLessThan50(item: Item) {
        if (item.quality < 50) {
            increaseItemQuality(item)

            if (!isNotBackstage(item.name)) {
                if (item.sellIn < 11) {
                    increaseItemQuality(item)
                }

                if (item.sellIn < 6) {
                    increaseItemQuality(item)
                }
            }
        }
    }

    private fun updateQualityWhenSellInLessThanZero(item: Item) {
        if (item.sellIn < 0) {
            if (isNotAgedBrie(item.name)) {
                if (isNotBackstage(item.name)) {
                    if (item.quality > 0) {
                        if (isNotSulfuras(item.name)) {
                            decreaseItemQuality(item)
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality
                }
            } else {
                if (item.quality < 50) {
                    increaseItemQuality(item)
                }
            }
        }
    }*/

    private fun isNotSulfuras(name: String): Boolean = name != SULFURAS

/*    private fun isNotBackstage(name: String): Boolean = name != BACKSTAGE

    private fun isNotAgedBrie(name: String): Boolean = name != AGED_BRIE*/

    private fun decreaseItemQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
            if (item.name == CONJURED) {
                item.quality = item.quality - 1
            }
        }
    }

    private fun increaseItemQuality(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }

    private fun decreaseItemSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }
}

