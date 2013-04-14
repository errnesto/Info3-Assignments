package rose;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class GildedRoseTest {
	static GildedRose shop;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		shop = new GildedRose();
		
		shop.items = new ArrayList<Item>();
		shop.items.add(new Item("+5 Dexterity Vest", 10, 20));
		shop.items.add(new Item("Aged Brie", 2, 0));
		shop.items.add(new Item("Elixir of the Mongoose", 5, 7));
		shop.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		shop.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		shop.items.add(new Item("Conjured Mana Cake", 3, 6));
		
		shop.updateQuality();
	}
	
	@Test
	public void testDexterity() {
		Item itm = shop.getItem("+5 Dexterity Vest");
		
		//Quality from 20 to 19
		assertEquals(19,itm.getQuality());
		//SellIn from 10 to 9
		assertEquals(9,itm.getSellIn());
	}
	
	@Test
	public void testAgedBrie() {
		Item itm = shop.getItem("Aged Brie");
		
		//Quality from 0 to 1
		assertEquals(1,itm.getQuality());
		//SellIn from 2 to 1
		assertEquals(1,itm.getSellIn());
	}
	
	@Test
	public void testElixir() {
		Item itm = shop.getItem("Elixir of the Mongoose");
		
		//Quality from 7 to 6
		assertEquals(6,itm.getQuality());
		//SellIn from 5 to 4
		assertEquals(4,itm.getSellIn());
	}
	
	@Test
	public void testSulfuras() {
		Item itm = shop.getItem("Sulfuras, Hand of Ragnaros");
		
		//Quality from 80 to 80
		assertEquals(80,itm.getQuality());
		//SellIn from 0 to 0
		assertEquals(0,itm.getSellIn());
	}
	
	@Test
	public void testMana() {
		Item itm = shop.getItem("Conjured Mana Cake");
		
		//Quality from 6 to 5
		assertEquals(5,itm.getQuality());
		//SellIn from 3 to 2
		assertEquals(2,itm.getSellIn());
	}
	
	@Test
	public void testBackstage() {
		Item itm = shop.getItem("Backstage passes to a TAFKAL80ETC concert");
		
		//Quality from 20 to 19
		assertEquals(21,itm.getQuality());
		//SellIn from 15 to 14
		assertEquals(14,itm.getSellIn());
	}
	
	@Test
	public void testBackstage10DaysLeft() {
		Item itm = shop.getItem("Backstage passes to a TAFKAL80ETC concert");
		for(int i = 0; i < 4;i++){
			shop.updateQuality();
		}
		//Quality now at 25
		assertEquals(25,itm.getQuality());
		//SellIn at 10
		assertEquals(10,itm.getSellIn());
		shop.updateQuality();
		//after update 2 points higher
		assertEquals(27,itm.getQuality());
	}
	
	@Test
	public void testBackstage5DaysLeft() {
		Item itm = shop.getItem("Backstage passes to a TAFKAL80ETC concert");
		for(int i = 0; i < 4;i++){
			shop.updateQuality();
		}
		//Quality now at 35
		assertEquals(35,itm.getQuality());
		//SellIn at 5
		assertEquals(5,itm.getSellIn());
		shop.updateQuality();
		//after update 3 points higher
		assertEquals(38,itm.getQuality());
	}
	
	@Test
	public void testBackstageConcertOver() {
		Item itm = shop.getItem("Backstage passes to a TAFKAL80ETC concert");
		for(int i = 0; i < 4;i++){
			shop.updateQuality();
		}

		//SellIn now over
		assertEquals(0,itm.getSellIn());
		shop.updateQuality();
		//after quality is 0
		assertEquals(0,itm.getQuality());
	}
	
	@Test
	public void SellInOver() {
		//we need a own test object
		shop.items.add(new Item("sellInAt0", 0, 10));
		Item itm = shop.getItem("sellInAt0");
		shop.updateQuality();
		//noe sell in is over and quality decreased 2 points from 10 to 8
		assertEquals(8,itm.getQuality());

	}
	
	@Test
	public void QualityOver50() {
		Item itm = shop.getItem("Aged Brie");
		for(int i = 0; i <= 50;i++){
			shop.updateQuality();
		}
		
		//Quality still at 50 and we updated a lot more than 50 times
		assertEquals(50,itm.getQuality());

	}
	
	@Test
	public void negativeQuality() {
		Item itm = shop.getItem("+5 Dexterity Vest");
		
		//Quality still at 0 and we updated a lot
		assertEquals(0,itm.getQuality());

	}

}
