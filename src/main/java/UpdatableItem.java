public class UpdatableItem extends Item {

	public UpdatableItem( String name, int sellIn, int quality ){
		super(name, sellIn, quality);
	}
	
	public void updateQuality(){
		this.setQuality( this.quality - 1 );
	}
	
	public void updateSellIn(){
		this.setSellIn( this.sellIn - 1);
	}
}
