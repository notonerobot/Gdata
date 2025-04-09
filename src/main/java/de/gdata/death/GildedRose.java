package de.gdata.death;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {    // wählt stelle im Array aus (objekte)
            if (!items[i].name.equals("Aged Brie")  // wenn das Item NICHT der Aged Brie ist
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // und es NICHT der Backstagepass ist?
                if (items[i].quality > 0) { // wenn die qualität 0 beträgt
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // wenn NICHT das item Sulfras ist
                        items[i].quality = items[i].quality - 1; // dann verringert sich die qualität um 1?
                    }
                } // alle Items die nicht Brie, Bakstagepass oder Sulfras sind verringern die qualität um 1 jeden Tag.
            } else {
                if (items[i].quality < 50) { // wenn die Item qualität unter 50 liegt
                    items[i].quality = items[i].quality + 1; // steigert die qualität um 1!

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // Wenn es der Backstagepass ist
                        if (items[i].sellIn < 11) { // wenn das verkaufsdatum unter 11 tagen steht
                            if (items[i].quality < 50) { // wenn die qualität unter 50 liegt
                                items[i].quality = items[i].quality + 1; // steigt die qualität um 1?
                            }
                        }

                        if (items[i].sellIn < 6) { // wenn das verkaufsdatum unter 6 Tagen steht
                            if (items[i].quality < 50) { // wenn die qualität unter 50 liegt
                                items[i].quality = items[i].quality + 1; // steigt die qualität um 1?
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // wenn das item NICHT Sulfras ist
                items[i].sellIn = items[i].sellIn - 1; // nähert sich das verkaufsdatum dem ende
            } // Bei sulfrus ändert sich nur das sell-by date um 1 jeden tag und nichts anderes.

            if (items[i].name.contains("Conjured")){
                items[i].quality= items[i].quality -1;
            }

            if (items[i].sellIn < 0) { //wenn das ablaufdatum ereicht ist
                if (!items[i].name.equals("Aged Brie")) { // wen es nicht der Brie ist
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { //wenn es nicht das backstageTicket ist
                        if (items[i].quality > 0) { // wenn die qualität 0 ereicht hat
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { //wenn es nicht die Sulfras ist
                                items[i].quality = items[i].quality - 1; //verringert die Item qualität um 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality; // immer 0 ???
                    }
                } else {
                    if (items[i].quality < 50) { //wenn die qualität unter 50 liegt
                        items[i].quality = items[i].quality + 1; // die Item qualität um 1 jeden tag erhöhen
                    }
                }
            }
        }
    }
}