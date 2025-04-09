package de.gdata.death;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
    }

    @Test
    void bar() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(39, app.items[0].quality);
    }
    @Test
    void barl() {
        Item[] items = new Item[] { new Item("Conjured thingimajik", 6, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("Conjured thingimajik", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(44, app.items[0].quality);
    }
}


