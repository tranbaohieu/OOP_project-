package mainPackage;

import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame1 extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JPanel interFace = new ImageJPanel("image/frame1.jpg");
	
	JButton demoButton = new ImageButton("image/project demo.jpg");
	JButton aboutButton = new ImageButton("image/about.jpg");
	
	public static void main(String[] args)
	{
		Frame1 frm = new Frame1();
		frm.setVisible(true);
	}

	public Frame1()
	{
		setSize(1100, 650);
		
		interFace.setBounds(0, 0, 1000, 650);
		interFace.setLayout(null);
		add(interFace);
		
		demoButton.setBounds( 700, 370, 330, 55);
		aboutButton.setBounds(700, 445 , 330, 55);
		
		
		interFace.add(demoButton);
		interFace.add(aboutButton);
		//interFace.add(HNtowers);
		

		//add EventHandler
		demoButton.addActionListener(this);
		aboutButton.addActionListener(this);
		setVisible(true);
		setLocation(150, 50);
	}
	
	
  
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == demoButton) {
			Main frm2 = new Main();
			this.setVisible(false);
		}
		if(e.getSource() == aboutButton) {
			new About();
			this.setVisible(false);
		}
		
								
	}
	
}

