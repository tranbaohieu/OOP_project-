package HanoiTower;

import java.util.ArrayList;
import java.util.List;

import mainPackage.Cube;

public class Column extends Cube {
	private static final long serialVersionUID = 1L;
	private static final int widthCol = 30 ;
	private static final int heightCol = 260;
	
	private static final int xCol1 = 100;
	private static final int xCol2 = 330;
	private static final int xCol3 = 560;
	
	private static final int yCol1 = 140;
	private static final int yCol2 = 140;
	private static final int yCol3 = 140;
	
	private static String imgSrc = "image/ColumnInox.jpg"; 
	private int bottom ;  			// vi tri y ma 1 brick co the dat vao 
	
	List<Brick> arrayBrick = new ArrayList<Brick>();
	
	public static int getWidthcol() {
		return widthCol;
	}

	public static int getHeightcol() {
		return heightCol;
	}

	public Column(int index) {
		super(imgSrc);
		if(index == 1 ) {
			setBounds(xCol1,yCol1,widthCol,heightCol);
			this.bottom = yCol1 + heightCol - 2;
		}
		else if(index == 2) {
			setBounds(xCol2,yCol2,widthCol,heightCol);
			this.bottom = yCol2 + heightCol - 2;
		}
		else if(index == 3) {
			setBounds(xCol3,yCol3,widthCol,heightCol);
			this.bottom = yCol3 + heightCol - 2;
		}
		
	}

	public int getBottom() {
		return bottom;
	}
	
	
	public void pushBrick(Brick newBrick) {
		arrayBrick.add(newBrick);
		this.bottom -= (Brick.getHeightBrick() + 2);
	}
	
	public Brick topBrick() {
		return arrayBrick.get(arrayBrick.size()-1);
	}
	
	public void popBrick() {
		arrayBrick.remove(arrayBrick.size()-1);
		this.bottom += (Brick.getHeightBrick() + 2);
	}
	
	
}
