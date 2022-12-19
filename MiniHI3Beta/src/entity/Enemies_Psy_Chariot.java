package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Enemies_Psy_Chariot extends Entity{

	public Enemies_Psy_Chariot(GamePanel gp) {
		
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
			
			Chariot = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_chariot.png"));
			DChariot = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_chariot_damage.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {

		if(gp.ui.commandNum == 2 || gp.ui.commandNum == 5) {
			double oneScale = 300/maxLife;
			double healthBarValue = oneScale*life;
			g2.setColor(Color.red);
			g2.fillRect(700 - (int)healthBarValue, 452, (int)healthBarValue, 15);
			g2.drawImage(Chariot, 520, 340, 100, 100, null);
			
			if(enemie == 1 || aniulti == 5) {
				g2.drawImage(DChariot, 520, 340, 100, 100, null);
			}
			if(enemie == 2) {
				g2.setColor(new Color(180, 62, 139));
				g2.drawOval(520, 365, 5, 50);
				g2.setColor(new Color(227, 82, 181));
				g2.drawOval(525, 370, 5, 40);
				g2.setColor(new Color(236, 150, 226));
				g2.drawOval(530, 375, 5, 30);
			}
			
			if(enemie == 3) {
				g2.setColor(new Color(180, 62, 139));
				g2.drawOval(370, 365, 5, 50);
				g2.setColor(new Color(227, 82, 181));
				g2.drawOval(375, 370, 5, 40);
				g2.setColor(new Color(236, 150, 226));
				g2.drawOval(380, 375, 5, 30);
			}
			
			if(enemie == 4) {
				g2.setColor(new Color(180, 62, 139));
				g2.drawOval(230, 365, 5, 50);
				g2.setColor(new Color(227, 82, 181));
				g2.drawOval(235, 370, 5, 40);
				g2.setColor(new Color(236, 150, 226));
				g2.drawOval(240, 375, 5, 30);
			}
			
			if(enemie == 5) {
				g2.setColor(new Color(180, 62, 139));
				g2.drawOval(155, 365, 5, 50);
				g2.setColor(new Color(227, 82, 181));
				g2.drawOval(160, 370, 5, 40);
				g2.setColor(new Color(236, 150, 226));
				g2.drawOval(165, 375, 5, 30);
			}
		}
	}
	
}
