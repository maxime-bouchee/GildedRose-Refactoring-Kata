package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `check quality foo when quality is 0`() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun `check quality foo when quality is 10`() {
        val items = arrayOf<Item>(Item("foo", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)

    }

    @Test
    fun `check quality Aged brie when quality is less than 50`() {
        val items = arrayOf<Item>(Item("Aged Brie", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)

    }

    @Test
    fun `check quality Backstage passes to a TAFKAL80ETC concert when quality is less than 50 and sellin less than 6`() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)

    }

    @Test
    fun `check quality foo when quality is less than 50 and sellin less than 0`() {
        val items = arrayOf<Item>(Item("foo", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)

    }

    @Test
    fun `check quality Aged Brie when quality is less than 50 and sellin less than 0`() {
        val items = arrayOf<Item>(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)

    }

    @Test
    fun `check quality Backstage passes to a TAFKAL80ETC concert when quality is less than 50 and sellin less than 0`() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }
}


