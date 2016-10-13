public class Favorite extends Contact {

	public static final int DEFAULT_SPEEDDIAL = 10;
	private int speedDial;
	private FavoriteContactFrame contactframe;
	
	public Favorite(String name, String number, String notes, int speedDial, String directory, int fWidth, int fHeight) {
		super(name, number, notes);
		this.setSpeedDial(speedDial);
		this.contactframe = new FavoriteContactFrame(directory,fWidth,fHeight);
		this.contactframe.setNameInfo(name);
		this.contactframe.setNumberInfo(number);
		this.contactframe.setNotesInfo(notes);
	}
	
	public Favorite(Favorite userFavorite){
		super(userFavorite.getName(),userFavorite.getNumber(),userFavorite.getNotes());
		this.setSpeedDial(userFavorite.getSpeedDial());
	}
	
	public Favorite(String name, String number, String notes, int speedDial)
	{
		super(name, number, notes);
		this.setSpeedDial(speedDial);
		this.setContactFrame();
	}
	
	public Favorite()
	{
		super();
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}

	public void setSpeedDial(int speedDial) {
		this.speedDial = speedDial;
	}

	public int getSpeedDial() {
		return this.speedDial;
	}
	
	public void setContactFrame(FavoriteContactFrame contactframe){
		this.contactframe = new FavoriteContactFrame(contactframe);
	}
	
	public void setContactFrame()
	{
		this.contactframe = new FavoriteContactFrame();
	}
	
	public FavoriteContactFrame getContactFrame(){
		return this.contactframe;
	}

}
