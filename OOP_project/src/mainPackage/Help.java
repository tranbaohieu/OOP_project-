package mainPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JPanel view;
	JButton back =new JButton("Back");
	
	public Help() {
		setTitle("HELP");
		view = new ImageJPanel("image/helpFrame2.jpg");///////////
		view.setBounds(0, 0, 1200, 620);
		view.setLayout(null);
		
		back.setBounds(1000, 503, 120, 40);
		
		view.add(back);
		
		setSize(1200, 620);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(view);
		setLocation(100, 50);
		back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			Main frm = new Main();
			setVisible(false);
			//frm.setVisible(true);
		}
	}
	
}

