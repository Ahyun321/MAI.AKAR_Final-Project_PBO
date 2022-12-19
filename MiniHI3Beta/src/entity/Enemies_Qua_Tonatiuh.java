package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Enemies_Qua_Tonatiuh extends Entity{

	public Enemies_Qua_Tonatiuh(GamePanel gp) {
		
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
			
			Tonatiuh = ImageIO.read(getClass().getResourceAsStream("/enemies/pixel_tonatiuh.png"));
			QAttack = ImageIO.read(getClass().getResourceAsStream("/others/Qua_Attack.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		if(gp.ui.commandNum == 6) {
			double oneScale = 300/maxLife;
			double healthBarValue = oneScale*life;
			g2.setColor(Color.red);
			g2.fillRect(700 - (int)healthBarValue, 452, (int)healthBarValue, 15);
			
			g2.drawImage(Tonatiuh, 520, 340, 100, 100, null);
			if(enemie == 1) {
				g2.drawImage(QAttack, 545, 400, 20, 20, null);
			}
			if(enemie == 2) {
				g2.drawImage(QAttack, 535, 390, 40, 40, null);
			}
			
			if(enemie == 3) {
				g2.drawImage(QAttack, 370, 360, 60, 60, null);
			}
			
			if(enemie == 4) {
				g2.drawImage(QAttack, 230, 350, 80, 80, null);
			}
			
//			if(enemie == 5) {
//				g2.drawImage(QAttack, 155, 340, 100, 100, null);
//			}
		}
	}
	
}
