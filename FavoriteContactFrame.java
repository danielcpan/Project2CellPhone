package edu.project_2;


import java.awt.*;
import javax.swing.*;

/**
* This class helps load and display an image from a file.
* Original source:  http://beginwithjava.blogspot.com/2009/01/loading-and-displaying-image-in-java.html
* @since 2016-10-04
*/
public class FavoriteContactFrame extends JPanel{
	
	private Image image; // Declare a name for our Image object.
	private Image background1;
	//private Image background2;
	//private Image background3;
	private Dimension window;  //Declare the dimensions of the window.
	private String infoName;
	private String infoNumber;
	private String infoNotes;
	

	/**
	 * Initializes the JPanel instance variables to default values and image to null
	 * */
	public FavoriteContactFrame(){
		   
		   super();  //Calling parent constructor to initialize all the instance variables in the JPanel class
		   image = null;
		   window = new Dimension(600, 400);  //Sets default window dimensions of 600 pixels wide X 400 pixel high
		   
	}
	
	/**
	 * Initializes the JPanel instance variables to default values and gets image with given directory
	 * @param directory - the location of the image to be displayed
	 * */
	public FavoriteContactFrame(String directory, int fWidth, int fHeight){
		   super();     
		   window = new Dimension(fWidth, fHeight);	//Sets window dimensions of fWidth pixels wide X fHeight pixel high		   
		   image = Toolkit.getDefaultToolkit().getImage(directory);  // Load an image file into our Image object.
		   background1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chad\\Pictures\\CECS274Proj2\\background2.jpg");
	}



	/** 
	* Overrides the one in JPanel. This is where the drawing happens. We don't have to call it in our program, it gets called
	* automatically whenever the panel needs to be redrawn, like when it it made visible or moved.
	* @param g - Graphics object used to draw the image
	*/
	@Override
	public void paintComponent(Graphics g){
	
		//int backgroundNum = (int) Math.random() * 3;
		
		  // Resizing our image to fit the window
		  Dimension originalImg = new Dimension(image.getWidth(this), image.getHeight(this));	    
		  Dimension resizedImg = getScaledDimension(originalImg, window);
		  Dimension originalBg = new Dimension(background1.getWidth(this), background1.getHeight(this));
		  Dimension resizedBg = getScaledDimensionBg(originalBg, window);
		  Font title = new Font("Monotype Corsiva", Font.BOLD, 55);
		  Font information = new Font("Impact", Font.PLAIN, 55);
		  	
		  
		// Draw our Image object.
		  g.drawImage(background1, 0, 0, resizedBg.width, (int) resizedBg.getHeight(), this);
		  g.setColor(Color.orange);
		  g.fillRect(0, 0, resizedImg.width + 20, resizedImg.height+20);
		  g.setColor(Color.red);
		  g.drawRect(0, 0, resizedImg.width + 20, resizedImg.height+20);
		  g.drawImage(image,10,10,resizedImg.width, resizedImg.height, this); // at location 10,10, with scaled width and height
		  g.setFont(title);
		  g.drawString("Name:",(int) window.getWidth()/2 + 40, 100);
		  g.fillRect((int) window.getWidth()/2 + 40, 105, 150, 5);
		  g.setFont(information);
		  g.drawString(infoName, (int) window.getWidth()/2 + 60, 200 );
		  g.setFont(title);
		  g.drawString("Number:", (int) window.getWidth()/2 + 40, 300);
		  g.fillRect((int) window.getWidth()/2 + 40, 305, 200, 5);
		  g.setFont(information);
		  g.drawString(infoNumber, (int) window.getWidth()/2 + 60, 400);
		  g.setFont(title);
		  g.drawString("Notes:", 10, (int) window.getHeight() - 100);
		  g.fillRect((int) 10, (int) window.getHeight() - 95, 150, 5);
		  g.setFont(information);
		  g.drawString(infoNotes, 185, (int) window.getHeight() - 100); 
		  
	 }
	
	/**
	 * Displays the image of the this object
	 * */
	public void displayContactImage(Favorite favContact){
		//Creating the window
		  JFrame frame = new JFrame("Favorite Contact: " + favContact.getName());  //title of the frame will be "Favorite Contact"
		  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //Exits the window when it is closed
		  frame.setSize(window.width, window.height);			//Sets the window size
		  
		//Displaying the image in the frame
		  frame.setContentPane(this); 
		  frame.setVisible(true);		
		
	}
  
  // helper method that scales the image based on window dimensions
  private static Dimension getScaledDimension(Dimension imgSize, Dimension windowSize) {

	    int original_width = imgSize.width;
	    int original_height = imgSize.height;
	    int window_width = windowSize.width;
	    int window_height = windowSize.height;
	    int new_width = original_width;
	    int new_height = original_height;

	    // first check if we need to scale width
	    if (original_width > window_width/2) {
	        //scale width to fit within 1/2 the window width
	        new_width = window_width/2;
	        //scale height to maintain aspect ratio
	        new_height = (new_width * original_height) / original_width;
	    }

	    // then check if we need to scale even with the new height
	    if (new_height > window_height) {
	        //scale height to fit 
	        new_height = window_height - 150;
	        //scale width to maintain aspect ratio
	        new_width = (new_height * original_width) / original_height;
	    }

	    return new Dimension(new_width, new_height);
	}
  private static Dimension getScaledDimensionBg(Dimension bgSize, Dimension windowSize) {
	  int new_width = (int)windowSize.getWidth();
	  int new_height = (int)windowSize.getHeight();
	  return new Dimension(new_width, new_height); 
  }
  public void setNameInfo(String info){
	  this.infoName = info;
  }
  public void setNumberInfo(String info){
	  this.infoNumber = info;
  }
  public void setNoteInfo(String info){
	  this.infoNotes = info;
  }

  /*public static void main(String arg[]){

	  int fWidth = 800;
	  int fHeight = 600;
	  

    //ContactImage contact = new ContactImage("C:\\Users\\Katherine\\Pictures\\totoro.jpg", fWidth, fHeight);
	  FavoriteContactFrame contact = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", fWidth, fHeight);
	  contact.displayContactImage();

 
  }*/
}