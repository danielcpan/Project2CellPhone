public class Favorite extends Contact {



	private int speedDial;

	public Favorite(Contact favorite, int speedDial) {
		super(favorite.getName(),favorite.getNumber(),favorite.getNotes());
		this.setSpeedDial(speedDial);
		
	}

	public void setSpeedDial(int speedDial) {
		this.speedDial = speedDial;
	}

	public int getSpeedDial() {
		return speedDial;
	}
	
	public void setAll() {

	}

}
