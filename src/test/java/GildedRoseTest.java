import static org.junit.Assert.*;

import org.junit.Assert;
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
		Assert.assertArrayEquals(knownValues, updateValues); 
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
		Assert.assertArrayEquals(knownValues, updateValues);
	}
}

