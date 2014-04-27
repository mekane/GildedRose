import static org.junit.Assert.*;
import org.junit.Test;

public class GildedRoseTest {

	//Regression Tests for Quality
	@Test
	public void verifyNoQualityRegressionDefaultValues() {
		GildedRose gr = new GildedRose();
		int[] knownValues = new int[]{20,0,7,80,20,6};
		int[] initValues = gr.getInitialQualityValues();
		assertArrayEquals( knownValues, initValues);
	}
	
	@Test
	public void verifyNoQualityRegressionAfterOneUpdate(){
		GildedRose gr = new GildedRose();
		int[] knownValues = new int[]{19,1,6,80,21,5};
		int[] updateValues = gr.getQualityValuesAfterOneUpdate();
		assertArrayEquals(knownValues, updateValues);
	}
	
	
	//Regression Tests for SellIn
	@Test
	public void verifyNoSellInRegressionDefaultValues() {
		GildedRose gr = new GildedRose();
		int[] knownValues = new int[]{10,2,5,0,15,3};
		int[] initValues = gr.getInitialSellInValues();
		assertArrayEquals( knownValues, initValues);
	}
	
	@Test
	public void verifyNoSellInRegressionAfterOneUpdate(){
		GildedRose gr = new GildedRose();
		int[] knownValues = new int[]{9,1,4,0,14,2};
		int[] updateValues = gr.getSellInValuesAfterOneUpdate();
		assertArrayEquals(knownValues, updateValues);
	}

	
	
	
	
	
	
	
	
}

