package mainPackage;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Image image;
	
	
	public void setImage(String imgSrc) {
		ImageIcon imageIcon = new ImageIcon(imgSrc);
		image = imageIcon.getImage();
	}
	
	public ImageButton(String imgSrc) {
		
		ImageIcon imageIcon = new ImageIcon(imgSrc);
		image = imageIcon.getImage();
	}
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this); // (x, y) = (100, 100)
    }
	
    
	 
}
