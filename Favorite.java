public class Favorite extends Contact {



	private int speedDial;
	private FavoriteContactFrame contactframe;
	

	public Favorite(Contact favorite, int speedDial, FavoriteContactFrame contactframe) {
		super(favorite.getName(),favorite.getNumber(),favorite.getNotes());
		this.setSpeedDial(speedDial);
		this.setContactFrame(contactframe);
		
	}

	public void setSpeedDial(int speedDial) {
		this.speedDial = speedDial;
	}

	public int getSpeedDial() {
		return speedDial;
	}
	public void setContactFrame(FavoriteContactFrame contactframe){
		this.contactframe = contactframe;
	}
	
	public FavoriteContactFrame getContactFrame(){
		return contactframe;
	}
	
	public void setAll() {

	}

}
