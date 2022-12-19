package background;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class bgmanager {
	
	GamePanel gp;
	bg[] bg;

	public bgmanager(GamePanel gp) {
		
		this.gp = gp;
		
		bg = new bg[2];
		
		getbgImage();
	}
	
	public void getbgImage() {
		
		try {
			
			bg[0] = new bg();
			bg[0].image = ImageIO.read(getClass().getResourceAsStream("/others/screen2.jpg"));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {

		g2.drawImage(bg[0].image, 0, 0, 720, 480, null);
		
	}
}
