public class BackstagePassItem extends UpdatableItem {

	public BackstagePassItem( String name, int sellIn, int quality ){
		super(name, sellIn, quality);
	}
	
	public void updateQuality(){
		int daysToSell = this.getSellIn();

		if ( daysToSell > 10 ){
			this.setQuality( this.quality + 1);			
		}
		else if ( daysToSell > 5 ){
			this.setQuality( this.quality + 2);			
		}
		else if ( daysToSell > 0 ){
			this.setQuality( this.quality + 3);
		}
		else {
			this.setQuality(0);
		}
		
		this.setQuality( Math.min( this.quality, 50));
	}
	
}
