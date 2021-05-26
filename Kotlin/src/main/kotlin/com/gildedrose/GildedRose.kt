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
                CONJURED -> updateQualityConjured(items[i])
                else -> {
                    decreaseItemQuality(items[i])
                    decreaseItemSellIn(items[i])
                    if(items[i].sellIn < 0){
                        decreaseItemQuality(items[i])
                    }
                }
            }
        }
    }

    private fun updateQualityAgedBrie(item: Item){
        increaseItemQuality(item)
        decreaseItemSellIn(item)
        if(item.sellIn < 0){
            increaseItemQuality(item)
        }
    }

    private fun updateQualityConjured(item: Item){
        decreaseItemQuality(item)
        decreaseItemQuality(item)
        decreaseItemSellIn(item)
        if(item.sellIn < 0){
            decreaseItemQuality(item)
            decreaseItemQuality(item)
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

    private fun decreaseItemQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
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

