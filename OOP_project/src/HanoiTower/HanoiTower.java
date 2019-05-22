package HanoiTower;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;


import mainPackage.ImageJPanel;

public class HanoiTower extends ImageJPanel implements mainPackage.Control {
	private static final long serialVersionUID = 1L;
	ImageJPanel mainContent;
	ImageJPanel Table;
	Column ColumArr[] = new Column[3];
	JLabel ThapHanoi;
	List<Brick> BrickList = new ArrayList<Brick>();
	int numberofBricks = 5;
	private Boolean Pause = false;
	public HanoiTower(String imgSrc) {
		super(imgSrc);
		setLayout(null); 
		setSize(700,600);
		setBackground(Color.GRAY);
		setLayout(null);
		
		//setLabel
		ThapHanoi = new JLabel("*.* THAP HA NOI *.*");
		ThapHanoi.setBounds(180,20,300,100);
		ThapHanoi.setForeground(Color.WHITE);
		ThapHanoi.setFont(new Font("Serif", Font.BOLD, 27));
		// setTable
		Table = new ImageJPanel("image/Table.jpeg");
		//Table.setBackground(Color.MAGENTA);
		Table.setLayout(null);
		Table.setBounds(0, 400,700,200);
		Table.add(ThapHanoi);
		 //addTable
		add(Table);
		
		// khoi tao column
		for(int i=0;i<3;i++) {
			ColumArr[i] = new Column(i+1);
			add(ColumArr[i]);
		}
	}
	
	public void init(int numOfBricks) {
		numberofBricks = numOfBricks;
		for(int i=0; i<numberofBricks;i++) {
			Brick newBrick = new Brick(5-i);
			newBrick.addToColumn(ColumArr[0]);
			BrickList.add(newBrick);
			add(BrickList.get(i));
		}
		for(int i=0;i<3;i++) {
			add(ColumArr[i]);
		}
	}
	
	public void start(Thread thread) {
		startChangeTower(numberofBricks, ColumArr[0], ColumArr[1], ColumArr[2],thread);
		javax.swing.JOptionPane.showMessageDialog(null, "FINISH");
	}
	public void pause() {
		Pause = true;
	}
	public void resume(Thread thread) {
		Pause = false;
		thread.resume();
	}
	public void next(Thread thread) {
		thread.resume();
	}
	
	public void startChangeTower(int soluongdia , Column colRoot, Column colTmp, Column colTarget,Thread thread) {
		if(soluongdia == 1) {
			colRoot.topBrick().moveTo(colTarget);
			if(Pause) thread.suspend();
		
		}
		else {
			startChangeTower(soluongdia - 1, colRoot, colTarget, colTmp,thread);
			startChangeTower(1, colRoot, colTmp, colTarget,thread);
			startChangeTower(soluongdia - 1, colTmp, colRoot, colTarget,thread);
		}
		
	}
}
