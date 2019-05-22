package Sort;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import mainPackage.ImageJPanel;

public class Sort extends ImageJPanel implements mainPackage.Control  {
	private static final long serialVersionUID = 1L;
	JPanel line;
	protected List<Domino> DomList = new ArrayList<Domino>();
	protected Boolean pause = false;
	
	public Sort(String imgSrc) {
		super(imgSrc);
		line = new JPanel();
		line.setBounds(0, 350, 700 , 2);
		line.setBackground(Color.WHITE);
		add(line);
		setLayout(null);
		setBackground(Color.GRAY);
		setSize(700,600);
		setLayout(null); 
	}
	
	@Override
	public void start(Thread thread) {
		Sort(thread);
	}
	@Override
	public void pause() {
		pause = true;
	}
	@Override
	public void resume(Thread thread) {
		pause = false;
		thread.resume();
		
	}
	@Override
	public void next(Thread thread) {
		thread.resume();
	}
	@Override
	public void init(int n) {
		for(int i=0;i<n;i++) {
			int value = ((int)(Math.random()*100) % 10) + 2 ;
			DomList.add(new Domino(i, value));
			add(DomList.get(i));
		}
		
	}
	public void swap(int index1,int index2) {
		Domino tmpDom = new Domino();
		int x1 = DomList.get(index1).getX();
		int y1 = DomList.get(index1).getY();
		int x2 = DomList.get(index2).getX();
		int y2 = DomList.get(index2).getY();
		
		tmpDom.setBounds(x2 ,350, 0, 0);
		DomList.get(index2).moveTo(tmpDom);
		
		tmpDom.setBounds(x2, y1, 0, 0);
		DomList.get(index1).moveTo(tmpDom);
		
		tmpDom.setBounds(x1, y2, 0, 0);
		DomList.get(index2).moveTo(tmpDom);
		
		Domino tmpDom1 = DomList.get(index1);
		DomList.set(index1, DomList.get(index2));
		DomList.set(index2, tmpDom1);
		
	}
	public void CauGio(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setIDominoLayout(Domino dom) {
		dom.setImage("image/Domino2.png");
		dom.getComponent(0).setForeground(Color.WHITE);
		repaint();
	}
	public void setJDominoLayout(Domino dom) {
		dom.setImage("image/Domino1.jpg");
		dom.getComponent(0).setForeground(Color.WHITE);
		repaint();
	}
	public void setJ1DominoLayout(Domino dom) {
		dom.setImage("image/BrickImage.jpg");
		dom.getComponent(0).setForeground(Color.WHITE);
		repaint();
	}
	public void setDefaultDominoLayout(Domino dom) {
		dom.setImage("image/Domino.jpg");
		dom.getComponent(0).setForeground(Color.BLACK);
		repaint();
	}
	public void Sort(Thread thread) {
		
	}
	
}
