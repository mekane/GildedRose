import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        initDefaultItems();

        updateQuality();
	}


	
	private static void initDefaultItems() {
		items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
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
            if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) 
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0)
            {
                if (!"Aged Brie".equals(items.get(i).getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
                            {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }

}