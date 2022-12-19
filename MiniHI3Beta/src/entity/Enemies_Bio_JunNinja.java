package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Enemies_Bio_JunNinja extends Entity{

	public Enemies_Bio_JunNinja(GamePanel gp) {
		
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
			
			JunNinja = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_junninja.png"));
			DJunNinja = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_junninja_damage.png"));
			AJunNinja = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_junninja_attack.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		if(gp.ui.commandNum == 1 || gp.ui.commandNum == 4) {
			double oneScale = 300/maxLife;
			double healthBarValue = oneScale*life;
			g2.setColor(Color.red);
			g2.fillRect(700 - (int)healthBarValue, 452, (int)healthBarValue, 15);
			
			if(enemie == 0) {
				g2.drawImage(JunNinja, 505, 340, 100, 100, null);
			}
			
			if(enemie == 1 || aniulti == 5) {
				g2.drawImage(DJunNinja, 505, 340, 100, 100, null);
			}
			
			if(enemie == 2) {
				g2.drawImage(JunNinja, 380, 320, 100, 100, null);
			}
			
			if(enemie == 3) {
				g2.drawImage(JunNinja, 240, 360, 100, 100, null);
			}
			
			if(enemie == 4) {
				g2.drawImage(JunNinja, 140, 340, 100, 100, null);
			}
			
			if(enemie == 5) {
				g2.drawImage(AJunNinja, 140, 340, 100, 100, null);
			}
		}
	}
	
}
