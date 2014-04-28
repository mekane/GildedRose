public class CheeseItem extends UpdatableItem {

	public CheeseItem( String name, int sellIn, int quality ){
		super(name, sellIn, quality);
	}
	
	public void updateQuality(){
		this.setQuality( Math.min(50, this.quality + 1));
	}
	
	public void updateSellIn(){
		this.setSellIn( this.sellIn - 1);
	}
}
