package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun approval() {
        val items = arrayOf(Item("+5 Dexterity Vest", 10, 20), //
            Item("Aged Brie", 2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            Item("Conjured Mana Cake", 3, 6))

        val app = GildedRose(items)

        val days = 2

        var result = ""
        for (i in 0 until days) {
            result += "-------- day $i --------\n"
            result += "name, sellIn, quality\n"

            for (item in items) result += "$item\n"
            result += "\n"
            app.updateQuality()
        }

        val MASTER = "-------- day 0 --------\n" +
                "name, sellIn, quality\n" +
                "+5 Dexterity Vest, 10, 20\n" +
                "Aged Brie, 2, 0\n" +
                "Elixir of the Mongoose, 5, 7\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Sulfuras, Hand of Ragnaros, -1, 80\n" +
                "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
                "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
                "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
                "Conjured Mana Cake, 3, 6\n\n" +
                "-------- day 1 --------\n" +
                "name, sellIn, quality\n" +
                "+5 Dexterity Vest, 9, 19\n" +
                "Aged Brie, 1, 1\n" +
                "Elixir of the Mongoose, 4, 6\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Sulfuras, Hand of Ragnaros, -1, 80\n" +
                "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
                "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
                "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
                "Conjured Mana Cake, 2, 5\n\n"
        assertEquals(MASTER, result)
    }
}


