public class ConjuredItem extends UpdatableItem {

	public ConjuredItem( String name, int sellIn, int quality ){
		super(name, sellIn, quality);
	}
	
	public void updateQuality(){
		if ( this.getSellIn() < 1 ){
			this.setQuality( java.lang.Math.max(this.quality-4, 0) );
		}
		else {
			this.setQuality( java.lang.Math.max(this.quality-2, 0) );
		}
	}
}
