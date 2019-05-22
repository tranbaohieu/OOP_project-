package Sort;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import mainPackage.Cube;
import mainPackage.Moveable;

public class Domino extends Cube implements Moveable {
	private static final long serialVersionUID = 1L;
	private int value;
	private static final int widthDomino = 50;
	private static String imgSrc = "image/Domino.jpg";
	
	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public static int getWidthdomino() {
		return widthDomino;
	}
	
	public Domino() {
		super(imgSrc);
	}
	
	public static String getImgSrc() {
		return imgSrc;
	}

	public static void setImgSrc(String imgSrc) {
		Domino.imgSrc = imgSrc;
	}

public Domino(int index, int value) {
		super(imgSrc);
		this.value = value;
		int X = index*(widthDomino+5) + 60;
		int Y = 350 - (value)*20;
		setBounds(X, Y, widthDomino, value*20);
		JLabel LBValue = new JLabel(value+"");
		LBValue.setBounds(19, 0,30,30);
		LBValue.setFont(new Font("Serif", Font.BOLD, 17));
		setLayout(null);
		add(LBValue);
		setBackground(Color.WHITE);
	}
	
	
	//@Override
	public void moveTo(Object dominoTarget) {
		Domino domTarget = (Domino)(dominoTarget);
		int xDich = domTarget.getX();
		int yDich = domTarget.getY();
		boolean up = false;
		boolean down = false;
		boolean right = false;
		boolean left = false;
		
		while(getX() != xDich || getY() != yDich) {
			if(getX() == xDich && getY() < yDich) {
				up = false;
				down = true;
				right = false;
				left = false;
			}
			if(getX() == xDich && getY() > yDich) {
				up = true;
				down = false;
				right = false;
				left = false;
			}
			if(getX() > xDich && getY() == yDich) {
				up = false;
				down = false;
				right = false;
				left = true;
			}
			if(getX() < xDich && getY() == yDich) {
				up = false;
				down = false;
				right = true;
				left = false;
			}
			if(getX() < xDich && getY() > yDich) {
				up = false;
				down = false;
				right = true;
				left = false;
			}
			if(getX() > xDich && getY() > yDich) {
				up = false;
				down = false;
				right = false;
				left = true;
			}
			if(up) {
				setLocation(getX(), getY()-1);
			}
			if(down) {
				setLocation(getX(),getY()+1);
			}
			if(right) {
				setLocation(getX()+1,getY());
			}
			if(left) {
				setLocation(getX()-1,getY());
			}
			
			try
	        {
	            Thread.sleep(3);
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
			
		}
		
	}
}
