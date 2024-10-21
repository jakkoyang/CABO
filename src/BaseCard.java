import java.io.File;
import java.util.ArrayList;

import processing.core.PImage;

public class BaseCard {
	protected boolean faceUp;
	private final int HEIGHT = 70;
	protected static processing.core.PApplet processing;
	protected int rank;
	protected String suit;
	private final int WIDTH = 50;
	private int x;
	private int y;
	private static processing.core.PImage cardBack;
	private processing.core.PImage cardImage;
	BaseCard(int rank, String suit){
		if(BaseCard.processing == null) {
			throw new IllegalStateException();
		}
		this.rank = rank;
		this.suit = suit;
		if (BaseCard.cardBack == null) {
		        BaseCard.cardBack = processing.loadImage("back.png"); 
		}
	    this.cardImage = processing.loadImage("images"+File.separator+rank+"_of_"+suit.toLowerCase()+".png"); 

	}
	public static void setProcessing(processing.core.PApplet processing) {
		BaseCard.processing = processing;
	}
	public int getRank() {
		if(rank == 13 && suit.equals("Diamonds")) {
			return -1;
		}
		return rank;
	}
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	@Override
	public String toString() {
		return suit + " " + rank;
	}
	public void draw(int xPosition, int yPosition) {
		x = xPosition;
		y = yPosition;
		processing.fill(255);
		processing.rect(xPosition, yPosition, WIDTH, HEIGHT);
	    if (cardImage != null) {
	        processing.image(cardImage, xPosition, yPosition, WIDTH, HEIGHT);
	    } else if (cardBack != null) {
	        processing.image(cardBack, xPosition, yPosition, WIDTH, HEIGHT);
	    }
	}
	public boolean isMouseOver() {
		if(processing.mouseX > x && processing.mouseX < x + WIDTH
		&& processing.mouseY > y && processing.mouseY < y + HEIGHT) {
			return true;
		}
		return false;
	}
}
