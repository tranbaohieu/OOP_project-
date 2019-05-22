package mainPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import HanoiTower.HanoiTower;
import Sort.InsertionSort;
import Sort.SellSort;

public class Main extends ImageJFrame implements Runnable , ActionListener {
	private static final long serialVersionUID = 1L;
	
	ImageJPanel view;
	HanoiTower  hanoiTower;
	InsertionSort insertSort;
	SellSort sellSort;
	
	ImageButton sellsortBT = new ImageButton("image/sellsortBT.jpg"); ;
	ImageButton insertsortBT = new ImageButton("image/insertsortBT.jpg");
	ImageButton hanoiBT= new ImageButton("image/hanoitower1.jpg");
	ImageButton startButton= new ImageButton("image/start.jpg");
	ImageButton pauseButton= new ImageButton("image/pause.jpg");
	ImageButton resetButton= new ImageButton("image/reset.jpg");
	ImageButton nextButton= new ImageButton("image/next.jpg"); 
	ImageButton resumeButton = new ImageButton("image/resume.jpg");
	JButton helpButton = new JButton("Help");
	JButton backButton = new JButton("Back");
	Thread thread = new Thread(this);
	ImageJPanel nowMainContent ;
	
	public Main() {
		super();
		view = new ImageJPanel("image/view.jpg");
		view.setBounds(700, 0, 300, 600);
		view.setBackground(Color.DARK_GRAY);		
		view.setLayout(null);
		
		sellsortBT.setBounds(20, 40, 240, 45);
		insertsortBT.setBounds(20, 100, 240, 45);
		hanoiBT.setBounds(20, 160, 240, 45);
		
		startButton.setBounds(115, 300, 50, 35);
		resumeButton.setBounds(20, 345, 115, 35);
		pauseButton.setBounds(145, 345, 115, 35);
		resetButton.setBounds(20, 300, 90, 35);
		nextButton.setBounds(170, 300, 90, 35);
		helpButton.setBounds(145, 445, 115, 35);
		backButton.setBounds(20, 445, 115, 35);
		
		startButton.addActionListener(this);
		resetButton.addActionListener(this);
		pauseButton.addActionListener(this);
		nextButton.addActionListener(this);
		insertsortBT.addActionListener(this);
		hanoiBT.addActionListener(this);
		sellsortBT.addActionListener(this);
		resumeButton.addActionListener(this);
		helpButton.addActionListener(this);
		backButton.addActionListener(this);
		
		view.add(sellsortBT);
		view.add(insertsortBT);
		view.add(hanoiBT);
		view.add(startButton);
		view.add(pauseButton);
		view.add(resetButton);
		view.add(nextButton);
		view.add(resumeButton);
		view.add(helpButton);
		view.add(backButton);
		add(view);
		
		hanoiTower = new HanoiTower("image/mainContent.jpg");
		hanoiTower.init(5);
		hanoiTower.setLocation(0, 0);
		setLocation(200, 50);
		nowMainContent = hanoiTower;
		add(hanoiTower);
		
		
		
		setSize(1000,600);
		setLayout(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
//	public static void main(String[] args) {
//		//new Main();
//		
//	}
	//@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			thread.start();
			startButton.setImage("image/start1.jpg");
		}
		if(e.getSource() == pauseButton) {
			startButton.setImage("image/start.jpg");
			repaint();
			((Control)(nowMainContent)).pause();
			
			
		}
		if(e.getSource() == nextButton) {
			((Control)(nowMainContent)).next(thread);
		}
		if(e.getSource() == resetButton) {
			thread.stop();
			thread = new Thread(this);
			remove(nowMainContent);
			startButton.setImage("image/start.jpg");
			repaint();
			
			try {
				HanoiTower tmp = (HanoiTower)(nowMainContent);
				hanoiTower = new HanoiTower("image/mainContent.jpg");
				hanoiTower.init(5);
				hanoiTower.setLocation(0, 0);
				add(hanoiTower);
				nowMainContent = hanoiTower;
			} catch (Exception e2) {
				try {
					SellSort sellTmp = (SellSort)(nowMainContent);
					sellSort = new SellSort("image/mainContent.jpg");
					sellSort.init(10);
					sellSort.setLocation(0, 0);
					add(sellSort);
					nowMainContent = sellSort;
				}
				catch(Exception e3) {
					insertSort = new InsertionSort("image/mainContent.jpg");
					insertSort.init(10);
					insertSort.setLocation(0, 0);
					add(insertSort);
					nowMainContent = insertSort;
				}
			}
			
			
			repaint();
		}
		if(e.getSource() == resumeButton) {
			startButton.setImage("image/start1.jpg");
			repaint();
			((Control)(nowMainContent)).resume(thread);
			
		}
		if(e.getSource()==insertsortBT) {
			thread.stop();
			thread = new Thread(this);
			remove(nowMainContent);
			startButton.setImage("image/start.jpg");
			repaint();
			insertSort = new InsertionSort("image/mainContent.jpg");
			insertSort.init(10);
			insertSort.setLocation(0, 0);
			add(insertSort);
			nowMainContent = insertSort;
			sellsortBT.setImage("image/sellsortBT.jpg");
			hanoiBT.setImage("image/HanoiBtn.jpg");
			insertsortBT.setImage("image/insertsort1.jpg");
			repaint();
		}
		if(e.getSource()==sellsortBT) {
			thread.stop();
			thread = new Thread(this);
			remove(nowMainContent);
			startButton.setImage("image/start.jpg");
			repaint();
			sellSort = new SellSort("image/mainContent.jpg");
			sellSort.init(10);
			sellSort.setLocation(0, 0);
			add(sellSort);
			nowMainContent = sellSort;
			sellsortBT.setImage("image/sellsort1.jpg");
			hanoiBT.setImage("image/HanoiBtn.jpg");
			insertsortBT.setImage("image/insertsortBT.jpg");
			repaint();
		}
		if(e.getSource()==hanoiBT) {
			thread.stop();
			thread = new Thread(this);
			remove(nowMainContent);
			startButton.setImage("image/start.jpg");
			repaint();
			hanoiTower = new HanoiTower("image/mainContent.jpg");
			hanoiTower.init(5);
			add(hanoiTower);
			nowMainContent = hanoiTower;
			sellsortBT.setImage("image/sellsortBT.jpg");
			hanoiBT.setImage("image/hanoitower1.jpg");
			insertsortBT.setImage("image/insertsortBT.jpg");
			repaint();
		}
		if(e.getSource()==helpButton) {
			new Help();
			setVisible(false);
		}
		if(e.getSource()==backButton) {
			new Frame1();
			setVisible(false);
		}
	}
	//@Override
	public void run() {
		((Control)(nowMainContent)).start(thread);
	}

}
