public class UpdatableItem extends Item {

	public UpdatableItem( String name, int sellIn, int quality ){
		super(name, sellIn, quality);
	}
	
	public void updateQuality(){
		if ( this.getSellIn() < 1 ){
			this.setQuality( java.lang.Math.max(this.quality-2, 0) );
		}
		else {
			this.setQuality( java.lang.Math.max(this.quality-1, 0) );
		}
	}
	
	public void updateSellIn(){
		this.setSellIn( this.sellIn - 1);
	}
}
