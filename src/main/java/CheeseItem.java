public class CheeseItem extends UpdatableItem {

	public CheeseItem( String name, int sellIn, int quality ){
		super(name, sellIn, quality);
	}
	
	public void updateQuality(){
		
		if ( this.getSellIn() < 1 ){
			this.setQuality( Math.min(50, this.quality + 2));
		}
		else {
			this.setQuality( Math.min(50, this.quality + 1));
		}
	}
	
	public void updateSellIn(){
		this.setSellIn( this.sellIn - 1);
	}
}
