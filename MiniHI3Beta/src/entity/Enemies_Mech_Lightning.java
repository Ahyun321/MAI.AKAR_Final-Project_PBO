package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Enemies_Mech_Lightning extends Entity{

	public Enemies_Mech_Lightning(GamePanel gp) {
		
		super(gp);
		
		maxLife = 4;
		life = maxLife;
		
		setDefaultValues();
		getImage();
	}
	
	public void setDefaultValues() {
		
		worldX = 520;
		worldY = 340;
		
		maxLife = 80;
		life = maxLife;
	}
	
	public void getImage() {
		
		try {
			
			Lightning = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_lightning.png"));
			DLightning = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_lightning_damage.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {

		if(gp.ui.commandNum == 0 || gp.ui.commandNum == 3) {
			double oneScale = 300/maxLife;
			double healthBarValue = oneScale*life;
			g2.setColor(Color.red);
			g2.fillRect(700 - (int)healthBarValue, 452, (int)healthBarValue, 15);
			g2.drawImage(Lightning, 520, 340, 100, 100, null);
			
			if(enemie == 1 || aniulti == 5) {
				g2.drawImage(DLightning, 520, 340, 100, 100, null);
			}
			if(enemie == 2) {
				g2.setColor(Color.BLUE);
				g2.fillRect(500, 370, 10, 2);
				g2.fillRect(502, 380, 10, 2);
				g2.fillRect(500, 390, 10, 2);
				g2.fillRect(502, 400, 10, 2);
				g2.fillRect(560, 380, 10, 2);
				g2.fillRect(562, 390, 10, 2);
				g2.fillRect(560, 400, 10, 2);
				g2.fillRect(562, 410, 10, 2);
				g2.setColor(Color.CYAN);
				g2.fillRect(495, 370, 10, 2);
				g2.fillRect(497, 380, 10, 2);
				g2.fillRect(495, 390, 10, 2);
				g2.fillRect(497, 400, 10, 2);
				g2.fillRect(555, 380, 10, 2);
				g2.fillRect(557, 390, 10, 2);
				g2.fillRect(555, 400, 10, 2);
				g2.fillRect(557, 410, 10, 2);
			}
			
			if(enemie == 3) {
				g2.setColor(Color.BLUE);
				g2.fillRect(370, 370, 10, 2);
				g2.fillRect(372, 380, 10, 2);
				g2.fillRect(370, 390, 10, 2);
				g2.fillRect(372, 400, 10, 2);
				g2.fillRect(410, 380, 10, 2);
				g2.fillRect(412, 390, 10, 2);
				g2.fillRect(410, 400, 10, 2);
				g2.fillRect(412, 410, 10, 2);
				g2.setColor(Color.CYAN);
				g2.fillRect(365, 370, 10, 2);
				g2.fillRect(367, 380, 10, 2);
				g2.fillRect(365, 390, 10, 2);
				g2.fillRect(367, 400, 10, 2);
				g2.fillRect(405, 380, 10, 2);
				g2.fillRect(407, 390, 10, 2);
				g2.fillRect(405, 400, 10, 2);
				g2.fillRect(407, 410, 10, 2);
			}
			
			if(enemie == 4) {
				g2.setColor(Color.BLUE);
				g2.fillRect(230, 370, 10, 2);
				g2.fillRect(232, 380, 10, 2);
				g2.fillRect(230, 390, 10, 2);
				g2.fillRect(232, 400, 10, 2);
				g2.fillRect(250, 380, 10, 2);
				g2.fillRect(252, 390, 10, 2);
				g2.fillRect(250, 400, 10, 2);
				g2.fillRect(252, 410, 10, 2);
				g2.setColor(Color.CYAN);
				g2.fillRect(225, 370, 10, 2);
				g2.fillRect(227, 380, 10, 2);
				g2.fillRect(225, 390, 10, 2);
				g2.fillRect(227, 400, 10, 2);
				g2.fillRect(235, 380, 10, 2);
				g2.fillRect(237, 390, 10, 2);
				g2.fillRect(235, 400, 10, 2);
				g2.fillRect(237, 410, 10, 2);
			}
			
			if(enemie == 5) {
				g2.setColor(Color.BLUE);
				g2.fillRect(155, 370, 10, 2);
				g2.fillRect(157, 380, 10, 2);
				g2.fillRect(155, 390, 10, 2);
				g2.fillRect(157, 400, 10, 2);

				g2.setColor(Color.CYAN);
				g2.fillRect(160, 370, 10, 2);
				g2.fillRect(162, 380, 10, 2);
				g2.fillRect(167, 390, 10, 2);
				g2.fillRect(162, 400, 10, 2);
			}
		}
	}
	
}
