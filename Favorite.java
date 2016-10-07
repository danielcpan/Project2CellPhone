public class Favorite extends Contact {

	private static final String DEFAULT_SPEED_DIAL = "";

	private int speedDial;

	public Favorite(Contact favorite, int speedDial) {
		super();
		setSpeedDial(DEFAULT_SPEED_DIAL);
	}

	public void setSpeedDial(String speedDial) {

	}

	public int getSpeedDial() {
		return speedDial;
	}

	public void setAll() {

	}

}
