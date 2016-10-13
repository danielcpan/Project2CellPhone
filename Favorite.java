public class Favorite extends Contact {



	private int speedDial;
	private String directory;
	private int width;
	private int height;
	private FavoriteContactFrame contactframe;
	

	public Favorite(String favName, String favNumber, String favNotes, int speedDial,String directory, int fWidth, int fHeight) {
		super(favName, favNumber, favNotes);
		this.setSpeedDial(speedDial);
		this.contactframe = new FavoriteContactFrame(directory,fWidth,fHeight);
		this.contactframe.setNameInfo(favName);
		this.contactframe.setNumberInfo(favNumber);
		this.contactframe.setNoteInfo(favNotes);
		
	}
	public Favorite(Favorite userFavorite){
		super(userFavorite.getName(),userFavorite.getNumber(),userFavorite.getNotes());
		this.setSpeedDial(userFavorite.getSpeedDial());
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
	
	public String getDirectory(){
		return directory;
	}
	public void setDirectory(String path){
		this.directory = path;
	}
	public int getWidth(){
		return width;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(int height){
		this.height = height;
	}
	
	
	public void setAll() {

	}

}
