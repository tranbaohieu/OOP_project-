package HanoiTower;


import mainPackage.Cube;
import mainPackage.Moveable;

public class Brick extends Cube implements Moveable {
	private static final long serialVersionUID = 1L;
	private int level;
	private static final int heightBrick = 40;
	private static String imgSrc = "image/BrickImage.jpg";
	private Column currentColumn;
	
	public static int getHeightBrick() {
		return heightBrick;
	}
	
	public int getLevel() {
		return level;
	}

	public Brick() {
		super(imgSrc);
		
	}
	
	public Brick(int level) {
		super(imgSrc);
		
		this.level = level;
		if(level == 5 ) {
			setSize(190, heightBrick);
			
		}
		if(level == 4 ) {
			setSize(160, heightBrick);
		}
		if(level == 3 ) {
			setSize(130, heightBrick);
		}
		if(level == 2 ) {
			setSize(100, heightBrick);
		}
		if(level == 1 ) {
			setSize(70, heightBrick);
		}
	}
	
	public void addToColumn(Column nextColumn) {
		int X = nextColumn.getX() - ( this.getWidth()-30 ) / 2;
		int Y = nextColumn.getBottom() - heightBrick;
		this.setLocation(X, Y);
		nextColumn.pushBrick(this);
		//currentColumn.popBrick();
		currentColumn = nextColumn;
	}
	
	public void moveTo(Object coltarget){
		Column columnTarget = (Column)(coltarget);
		boolean up = true;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		
		int xDich = columnTarget.getX() - ( this.getWidth()-30 ) / 2 ;
		int yDich = columnTarget.getBottom() - heightBrick;
		
		while(getX() != xDich  || getY() != yDich ) {
			if( getY() <= 50 && getX() < xDich ) {
			//System.out.println("phai");
				up = false;
				right = true;
				down = false;
				left = false;
			}
			if( getY() <= 50 && getX() > xDich ) {
			//System.out.println("trai");
				up = false;
				left = true;
				right = false;
				down = false;
			}
			if( getY() < yDich && getX() == xDich ) {
			//System.out.println("xuong");
				up = false;
				left = false;
				right = false;
				down = true;
			}
			if(up) setLocation(getX(), getY()-1);
			if(left) setLocation(getX()-1, getY());
			if(right) setLocation(getX()+1, getY());
			if(down) setLocation(getX(),getY()+1);
			try
            {
                Thread.sleep(3);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
		}
		
		columnTarget.pushBrick(this);
		currentColumn.popBrick();
		currentColumn = columnTarget;
		
	}
}
