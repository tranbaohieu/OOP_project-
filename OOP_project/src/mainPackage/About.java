package mainPackage;


import javax.swing.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
	JPanel view;
	JButton back = new ImageButton("image/AboutBackButton.jpg");
	
	public About() {
		setTitle("ABOUT");
		view = new ImageJPanel("image/aboutFrame1.jpg");
		view.setBounds(0, 0, 1100, 650);
		view.setLayout(null);
		back.setBounds(900, 500, 140, 45);
		
		view.add(back);
		setSize(1100, 650);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(150, 50);
		add(view);
		back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			Frame1 frm = new Frame1();
			setVisible(false);
			frm.setVisible(true);
		}
	}
	

}
