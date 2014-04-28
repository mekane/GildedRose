import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

	//Regression Tests for Quality
	@Test
	public void verifyNoQualityRegressionDefaultValues() {
		int[] knownValues = new int[]{20,0,7,80,20,6};
		int[] initValues = GildedRose.getInitialQualityValues();
		assertArrayEquals( knownValues, initValues);
	}
	
	@Test
	public void verifyNoQualityRegressionAfterOneUpdate(){
		int[] knownValues = new int[]{19,1,6,80,21,5};
		int[] updateValues = GildedRose.getQualityValuesAfterOneUpdate();
		assertArrayEquals(knownValues, updateValues);
	}
	
	@Test
	public void verifyNoQualityRegressionAfterTenUpdates(){
		int[] knownValues = new int[]{10,18,0,80,35,0};
		int[] updateValues = GildedRose.getQualityValuesAfterN_Updates(10);
		assertArrayEquals(knownValues, updateValues); 
	}
	
	
	//Regression Tests for SellIn
	@Test
	public void verifyNoSellInRegressionDefaultValues() {
		int[] knownValues = new int[]{10,2,5,0,15,3};
		int[] initValues = GildedRose.getInitialSellInValues();
		assertArrayEquals( knownValues, initValues);
	}
	
	@Test
	public void verifyNoSellInRegressionAfterOneUpdate(){
		int[] knownValues = new int[]{9,1,4,0,14,2};
		int[] updateValues = GildedRose.getSellInValuesAfterOneUpdate();
		assertArrayEquals(knownValues, updateValues);
	}

	@Test
	public void verifyNoSellInRegressionAfterTenUpdates(){
		int[] knownValues = new int[]{0,-8,-5,0,5,-7};
		int[] updateValues = GildedRose.getSellInValuesAfterN_Updates(10);
		assertArrayEquals(knownValues, updateValues);
	}
	
	
	//New Unit Tests
	@Test
	public void normalItemsLowerSellByAfterOneUpdate(){
		UpdatableItem i = new UpdatableItem("Name", 20, 20);
		i.updateSellIn();
		assertEquals( 19, i.getSellIn() );
	}
	
	@Test
	public void normalItemsDegradeOneQualityAfterOneUpdate() {
		UpdatableItem i = new UpdatableItem("Name", 20, 20);
		i.updateQuality();
		assertEquals( 19, i.getQuality() );
	}
	
	//Legendary
	@Test
	public void legendaryItemsDoNotDegradeQuality(){
		LegendaryItem i = new LegendaryItem("Name", 20, 20);
		i.updateQuality();
		assertEquals( 20, i.getQuality() );		
	}
	
	@Test
	public void legendaryItemsDoNotLowerSellIn(){
		LegendaryItem i = new LegendaryItem("Name", 20, 20);
		i.updateQuality();
		assertEquals( 20, i.getSellIn() );
	}
	
	//Cheese
	@Test
	public void cheeseItemsIncreaseInQuality(){
		CheeseItem i = new CheeseItem("Name", 20, 20);
		i.updateQuality();
		assertEquals( 21, i.getQuality() );
	}
	
	@Test
	public void cheeseItemsQualityCannotGoAboveFifty(){
		CheeseItem i = new CheeseItem("Name", 20, 50);
		i.updateQuality();
		assertEquals( 50, i.getQuality() );
	}
	
	//Backstage Passes
	@Test
	public void backstagePassItemsIncreaseQualityWithTenDaysOrMoreToSell(){
		BackstagePassItem i = new BackstagePassItem("Name", 20, 20);
		i.updateQuality();
		assertEquals( 21, i.getQuality() );
	}
	
	@Test
	public void backstagePassItemsIncreaseQualityByTwoWithTenDaysOrLessToSell(){
		BackstagePassItem i = new BackstagePassItem("Name", 10, 20);
		i.updateQuality();
		assertEquals( 22, i.getQuality() );
	}
	
	@Test
	public void backstagePassItemsIncreaseQualityByThreeWithFiveDaysOrLessTosell(){
		BackstagePassItem i = new BackstagePassItem("Name", 5, 20);
		i.updateQuality();
		assertEquals( 23, i.getQuality() );
	}

	@Test
	public void backstagePassItemsQualityGoesToZeroWithNoDaysToSell(){
		BackstagePassItem i = new BackstagePassItem("Name", 0, 20);
		i.updateQuality();
		assertEquals( 0, i.getQuality() );
	}

	@Test
	public void backstagePassItemsQualityCannotGoAboveFifty(){
		BackstagePassItem i = new BackstagePassItem("Name", 20, 50);
		i.updateQuality();
		assertEquals( 50, i.getQuality() );
	}
}

