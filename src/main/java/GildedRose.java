import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<UpdatableItem> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        initDefaultItems();

        updateQuality();
        
        printSellInValues();
	}


	
	private static void initDefaultItems() {
		items = new ArrayList<UpdatableItem>();
        items.add(new UpdatableItem("+5 Dexterity Vest", 10, 20));
        items.add(new CheeseItem("Aged Brie", 2, 0));
        items.add(new UpdatableItem("Elixir of the Mongoose", 5, 7));
        items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new UpdatableItem("Conjured Mana Cake", 3, 6));
	}
	
	private static void printQualityValues(){
		System.out.println("Quality Values:");
		for ( Item i : items ){
			System.out.println(i.getName()+": "+i.getQuality());
		}
	}
	
	private static void printSellInValues(){
		System.out.println("SellIn Values:");
		for ( Item i : items ){
			System.out.println(i.getName()+": "+i.getSellIn());
		}
	}
	
	public static int[] getInitialQualityValues(){
		initDefaultItems();
	
		int[] result = new int[items.size()];
		for (int i = 0; i < items.size(); i++){
			result[i] = items.get(i).getQuality();
		}
		return result;
	}
	
	public static int[] getInitialSellInValues(){
		initDefaultItems();
		
		int[] result = new int[items.size()];
		for (int i = 0; i < items.size(); i++){
			result[i] = items.get(i).getSellIn();
		}
		return result;
	}
	
	public static int[] getQualityValuesAfterOneUpdate(){
		initDefaultItems();
		updateQuality();
		
		int[] result = new int[items.size()];
		for (int i = 0; i < items.size(); i++){
			result[i] = items.get(i).getQuality();
		}
		
		return result;
	}
	
	public static int[] getSellInValuesAfterOneUpdate(){
		initDefaultItems();
		updateQuality();
		
		int[] result = new int[items.size()];
		for (int i = 0; i < items.size(); i++){
			result[i] = items.get(i).getSellIn();
		}
		return result;
	}
	
	public static int[] getQualityValuesAfterN_Updates( int numberOfUpdates ){
		initDefaultItems();
		
        for ( int runs = numberOfUpdates; runs > 0 ; runs-- ){
        	updateQuality();
        }
		
		int[] result = new int[items.size()];
		for (int i = 0; i < items.size(); i++){
			result[i] = items.get(i).getQuality();
		}
		
		return result;
	}
	
	public static int[] getSellInValuesAfterN_Updates( int numberOfUpdates){
		initDefaultItems();
		
        for ( int runs = numberOfUpdates; runs > 0 ; runs-- ){
        	updateQuality();
        }
		
		int[] result = new int[items.size()];
		for (int i = 0; i < items.size(); i++){
			result[i] = items.get(i).getSellIn();
		}
		return result;
	}
	
	
	

	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            items.get(i).updateQuality();
        	items.get(i).updateSellIn();
        }
    }

}