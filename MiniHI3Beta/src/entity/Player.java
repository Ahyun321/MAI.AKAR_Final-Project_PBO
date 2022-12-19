package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyPanel;

public class Player extends Entity{

	KeyPanel KeyP;
	
	public Player(GamePanel gp, KeyPanel KeyP) {
		
		super(gp);

		this.KeyP = KeyP;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		worldX = 100;
		worldY = 340;
		
		maxLife = 80;
		life = maxLife;
	}
	
	public void getPlayerImage() {
		
		try {
			
			icon = ImageIO.read(getClass().getResourceAsStream("/others/tes icon.png"));
			icon2 = ImageIO.read(getClass().getResourceAsStream("/others/tes icon plain.png"));
			bg = ImageIO.read(getClass().getResourceAsStream("/others/screen_blur.png"));
			bg2 = ImageIO.read(getClass().getResourceAsStream("/others/screen2.jpg"));
			hyperion = ImageIO.read(getClass().getResourceAsStream("/others/hyperion.jpg"));
			guide = ImageIO.read(getClass().getResourceAsStream("/others/guide screen2.png"));
			
			kiana = ImageIO.read(getClass().getResourceAsStream("/player/pixel_kiana2.png"));
			wkiana = ImageIO.read(getClass().getResourceAsStream("/player/pixel_wkiana2.png"));
			mei = ImageIO.read(getClass().getResourceAsStream("/player/pixel_mei2.png"));
			wmei = ImageIO.read(getClass().getResourceAsStream("/player/pixel_wmei2.png"));
			bronya = ImageIO.read(getClass().getResourceAsStream("/player/pixel_bronya2.png"));
			bronyacut = ImageIO.read(getClass().getResourceAsStream("/player/pixel_bronya_cut.png"));
			wbronya = ImageIO.read(getClass().getResourceAsStream("/player/pixel_wbronya2.png"));
			
			b_heal = ImageIO.read(getClass().getResourceAsStream("/others/button_heal.png"));
			b_attack_kiana = ImageIO.read(getClass().getResourceAsStream("/others/button_kiana_attack.png"));
			b_attack_mei = ImageIO.read(getClass().getResourceAsStream("/others/button_mei_attack.png"));
			b_attack_bronya = ImageIO.read(getClass().getResourceAsStream("/others/button_bronya_attack.png"));
			b_ulti_kiana = ImageIO.read(getClass().getResourceAsStream("/others/button_kiana_ultimate.png"));
			b_ulti_mei = ImageIO.read(getClass().getResourceAsStream("/others/button_mei_ultimate.png"));
			b_ulti_bronya = ImageIO.read(getClass().getResourceAsStream("/others/button_bronya_ultimate.png"));
			
			ani_mei_attack1 = ImageIO.read(getClass().getResourceAsStream("/player/animation_mei_attack1.png"));
			ani_mei_attack2 = ImageIO.read(getClass().getResourceAsStream("/player/animation_mei_attack2.png"));
			ani_bronya_attack1 = ImageIO.read(getClass().getResourceAsStream("/player/animation_bronya_attack1.png"));
			ani_bronya_attack2 = ImageIO.read(getClass().getResourceAsStream("/player/animation_bronya_attack2.png"));
			
			DKiana = ImageIO.read(getClass().getResourceAsStream("/player/pixel_wkiana2_damage.png"));
			DMei = ImageIO.read(getClass().getResourceAsStream("/player/pixel_wmei2_damage.png"));
			DBronya = ImageIO.read(getClass().getResourceAsStream("/player/pixel_wbronya2_damage.png"));
			
			kiana_ulti1 = ImageIO.read(getClass().getResourceAsStream("/player/animation_kiana_ulti1.png"));
			kiana_ulti2 = ImageIO.read(getClass().getResourceAsStream("/player/animation_kiana_ulti2.png"));
			kiana_ulti3 = ImageIO.read(getClass().getResourceAsStream("/player/animation_kiana_ulti3.png"));
			kiana_ulti4 = ImageIO.read(getClass().getResourceAsStream("/player/animation_kiana_ulti4.png"));
			kiana_ulti5 = ImageIO.read(getClass().getResourceAsStream("/player/animation_kiana_ulti5.png"));
			kiana_ulti6 = ImageIO.read(getClass().getResourceAsStream("/player/animation_kiana_ulti6.png"));
			
			mei_ulti1 = ImageIO.read(getClass().getResourceAsStream("/player/animation_mei_ulti1.png"));
			mei_ulti2 = ImageIO.read(getClass().getResourceAsStream("/player/animation_mei_ulti2.png"));
			
			bronya_ulti1 = ImageIO.read(getClass().getResourceAsStream("/player/animation_bronya_ulti1.png"));
			bronya_ulti2 = ImageIO.read(getClass().getResourceAsStream("/player/animation_bronya_ulti2.png"));
			bronya_ulti3 = ImageIO.read(getClass().getResourceAsStream("/player/animation_bronya_ulti3.png"));
			bronya_ulti4 = ImageIO.read(getClass().getResourceAsStream("/player/animation_bronya_ulti4.png"));
			
			QAttack = ImageIO.read(getClass().getResourceAsStream("/others/Qua_Attack.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(new Color(67, 118, 171));
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
		g2.fillOval(15, 350, 75, 75);
		g2.fillOval(15, 260, 75, 75);
		g2.setColor(Color.orange);
		g2.fillOval(15, 170, 75, 75);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
		g2.setFont(new Font("Times New Roman",Font.BOLD,10));
		g2.setColor(new Color(102, 178, 255));
		g2.fillRoundRect(43, 344, 17, 13, 5, 5);
		g2.fillRoundRect(43, 254, 17, 13, 5, 5);
		g2.setColor(Color.orange);
		g2.fillRoundRect(43, 164, 17, 13, 5, 5);
		g2.setColor(Color.white);
		g2.drawRoundRect(43, 344, 17, 13, 5, 5);
		g2.drawRoundRect(43, 254, 17, 13, 5, 5);
		g2.drawRoundRect(43, 164, 17, 13, 5, 5);
		g2.drawString("Z", 48, 354);
		g2.drawString("X", 48, 264);
		g2.drawString("C", 48, 174);
		
		if(button == 2) {
			g2.setColor(new Color(102, 178, 255));
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillOval(15, 260, 75, 75);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
		}
		g2.drawImage(b_heal, 15, 260, 75, 75, null);
		
		if(character == 0) {
			if(button == 1) {
				g2.setColor(new Color(102, 178, 255));
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillOval(15, 350, 75, 75);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			}
			
			g2.drawImage(b_attack_kiana, 15, 350, 75, 75, null);
			g2.drawImage(b_ulti_kiana, 15, 170, 75, 75, null);
			
			if(ultimate % 5 != 0 || ultimate == 0) {
				g2.setColor(Color.gray);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
				g2.fillRoundRect(43, 164, 17, 13, 5, 5);
				g2.fillOval(15, 170, 75, 75);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.white);
				g2.drawRoundRect(43, 164, 17, 13, 5, 5);
				g2.drawString("C", 48, 174);
			}
			
			if(aniulti == 0) {
				g2.drawImage(wkiana, worldX, worldY, 125, 100, null);
			}
			if(aniulti == 1) {
				g2.drawImage(kiana_ulti1, worldX, worldY, 125, 100, null);
				g2.drawImage(kiana_ulti4, 480, 330, 125, 100, null);
			}
			if(aniulti == 2) {
				g2.drawImage(kiana_ulti2, worldX, worldY, 125, 100, null);
				g2.drawImage(kiana_ulti4, 480, 330, 125, 100, null);
			}
			if(aniulti == 3) {
				g2.drawImage(kiana_ulti3, worldX, worldY, 125, 100, null);
				g2.drawImage(kiana_ulti5, 480, 330, 125, 100, null);
			}
			if(aniulti == 4) {
				g2.drawImage(kiana_ulti3, worldX, worldY, 125, 100, null);
				g2.drawImage(kiana_ulti6, 480, 330, 125, 100, null);
			}
			if(aniulti == 5) {
				g2.drawImage(kiana_ulti3, worldX, worldY, 125, 100, null);
				g2.drawImage(kiana_ulti6, 480, 330, 125, 100, null);
			}
			
			g2.setColor(Color.orange);//kelipatan 84
			if(animation == 1) {
				g2.fillRect(188, 384, 20, 2);
			}
			
			if(animation == 2) {
				g2.fillRect(268, 384, 20, 2);
			}
			
			if(animation == 3) {
				g2.fillRect(352, 384, 20, 2);
			}
			
			if(animation == 4) {
				g2.fillRect(436, 384, 20, 2);
			}
			
			if(animation == 5) {
				g2.fillRect(520, 384, 20, 2);
			}
			
			if(enemie == 5) {
				g2.drawImage(DKiana, worldX, worldY, 125, 100, null);
				if(gp.ui.commandNum == 6) {
					g2.drawImage(QAttack, 155, 340, 100, 100, null);
				}
			}
			
			g2.setColor(Color.red);
			if(animation == 6 ) {
				g2.fillRect(145, 360, 6, 2);
				g2.fillRect(147, 358, 2, 6);
			}
			
			if(animation == 7 ) {
				g2.fillRect(180, 370, 6, 2);
				g2.fillRect(182, 368, 2, 6);
			}
			
			if(animation == 8 ) {
				g2.fillRect(144, 389, 6, 2);
				g2.fillRect(146, 387, 2, 6);
			}
			
			if(animation == 9 ) {
				g2.fillRect(170, 355, 6, 2);
				g2.fillRect(172, 353, 2, 6);
			}
			
		}
		if(character == 1) {
			if(button == 1) {
				g2.setColor(new Color(102, 178, 255));
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillOval(15, 350, 75, 75);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			}
			
			g2.drawImage(b_attack_mei, 15, 350, 75, 75, null);
			g2.drawImage(b_ulti_mei, 15, 170, 75, 75, null);
			
			if(ultimate % 5 != 0 || ultimate == 0) {
				g2.setColor(Color.gray);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
				g2.fillRoundRect(43, 164, 17, 13, 5, 5);
				g2.fillOval(15, 170, 75, 75);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.white);
				g2.drawRoundRect(43, 164, 17, 13, 5, 5);
				g2.drawString("C", 48, 174);
			}
			
			if(aniulti == 0 && animation == 0) {
				g2.drawImage(wmei, worldX, worldY, 125, 100, null);
			}
			if(aniulti == 1) {
				g2.drawImage(ani_mei_attack1, worldX, worldY, 125, 100, null);
			}
			if(aniulti == 2) {
				g2.drawImage(mei_ulti1, worldX, worldY, 125, 100, null);
			}
			if(aniulti == 3) {
				g2.drawImage(ani_mei_attack2, worldX, worldY, 125, 100, null);
				g2.drawImage(mei_ulti2, 220, worldY, 125, 100, null);
			}
			if(aniulti == 4) {
				g2.drawImage(ani_mei_attack2, worldX, worldY, 125, 100, null);
				g2.drawImage(mei_ulti2, 340, worldY, 125, 100, null);
			}
			if(aniulti == 5) {
				g2.drawImage(ani_mei_attack1, worldX, worldY, 125, 100, null);
				g2.drawImage(mei_ulti2, 460, worldY, 125, 100, null);
			}
			
			if (animation == 1) {
				g2.drawImage(ani_mei_attack1, worldX, worldY, 125, 100, null);
			}
			
			if (animation == 2) {
				g2.drawImage(ani_mei_attack1, worldX + 210, worldY, 125, 100, null);
			}
			
			if (animation == 3) {
				g2.drawImage(ani_mei_attack1, worldX + 360, worldY, 125, 100, null);
			}
			
			if (animation == 4) {
				g2.drawImage(ani_mei_attack2, worldX + 360, worldY, 125, 100, null);
			}
			
			if (animation == 5) {
				g2.drawImage(ani_mei_attack1, worldX, worldY, 125, 100, null);
			}
			
			if(enemie == 5) {
				g2.drawImage(DMei, worldX, worldY, 125, 100, null);
				if(gp.ui.commandNum == 6) {
					g2.drawImage(QAttack, 155, 340, 100, 100, null);
				}
			}
			
			g2.setColor(Color.red);
			if(animation == 6 ) {
				g2.drawImage(wmei, worldX, worldY, 125, 100, null);
				g2.fillRect(145, 360, 6, 2);
				g2.fillRect(147, 358, 2, 6);
			}
			
			if(animation == 7 ) {
				g2.drawImage(wmei, worldX, worldY, 125, 100, null);
				g2.fillRect(180, 370, 6, 2);
				g2.fillRect(182, 368, 2, 6);
			}
			
			if(animation == 8 ) {
				g2.drawImage(wmei, worldX, worldY, 125, 100, null);
				g2.fillRect(144, 382, 6, 2);
				g2.fillRect(146, 380, 2, 6);
			}
			
			if(animation == 9 ) {
				g2.drawImage(wmei, worldX, worldY, 125, 100, null);
				g2.fillRect(170, 355, 6, 2);
				g2.fillRect(172, 353, 2, 6);
			}
		}
		if(character == 2) {
			if(button == 1) {
				g2.setColor(new Color(102, 178, 255));
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillOval(15, 350, 75, 75);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			}	
			g2.drawImage(b_attack_bronya, 15, 350, 75, 75, null);
			g2.drawImage(b_ulti_bronya, 15, 170, 75, 75, null);
			
			if(ultimate % 5 != 0 || ultimate == 0) {
				g2.setColor(Color.gray);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
				g2.fillRoundRect(43, 164, 17, 13, 5, 5);
				g2.fillOval(15, 170, 75, 75);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.white);
				g2.drawRoundRect(43, 164, 17, 13, 5, 5);
				g2.drawString("C", 48, 174);
			}
			
			if(aniulti == 0 && animation == 0) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
			}
			if(aniulti == 1) {
				g2.drawImage(bronya_ulti1, worldX, worldY - 5, 125, 100, null);
				g2.drawImage(bronya_ulti3, 505, 330, 125, 100, null);
			}
			if(aniulti == 2) {
				g2.drawImage(bronya_ulti1, worldX, worldY - 5, 125, 100, null);
				g2.drawImage(bronya_ulti4, 505, 330, 125, 100, null);
			}
			if(aniulti == 3) {
				g2.drawImage(bronya_ulti1, worldX, worldY - 5, 125, 100, null);
				g2.drawImage(bronya_ulti2, 505, 330, 125, 100, null);
			}
			if(aniulti == 4) {
				g2.drawImage(bronya_ulti1, worldX, worldY - 5, 125, 100, null);
				g2.drawImage(bronya_ulti3, 505, 330, 125, 100, null);
			}
			if(aniulti == 5) {
				g2.drawImage(bronya_ulti1, worldX, worldY - 5, 125, 100, null);
				g2.drawImage(bronya_ulti4, 505, 330, 125, 100, null);
			}
			
			if (animation == 1) {
				g2.drawImage(ani_bronya_attack1, worldX, worldY, 125, 100, null);
			}
			
			if (animation == 2) {
				g2.drawImage(ani_bronya_attack2, worldX, worldY, 125, 100, null);
			}
			
			if (animation == 3) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
				g2.setColor(new Color(250, 198, 96));
				g2.fillRoundRect(212, 365, 20, 8, 5, 5);
				g2.setColor(new Color(215, 109, 26));
				g2.fillRoundRect(215, 366, 18, 6, 5, 5);
			}
			
			if (animation == 4) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
				g2.setColor(new Color(250, 198, 96));
				g2.fillRoundRect(356, 365, 20, 8, 5, 5);
				g2.setColor(new Color(215, 109, 26));
				g2.fillRoundRect(359, 366, 18, 6, 5, 5);
			}
			
			if (animation == 5) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
				g2.setColor(new Color(250, 198, 96));
				g2.fillRoundRect(520, 365, 20, 8, 5, 5);
				g2.setColor(new Color(215, 109, 26));
				g2.fillRoundRect(523, 366, 18, 6, 5, 5);
			}
			
			if(enemie == 5) {
				g2.drawImage(DBronya, worldX, worldY, 125, 100, null);
				if(gp.ui.commandNum == 6) {
					g2.drawImage(QAttack, 155, 340, 100, 100, null);
				}
			}
			
			g2.setColor(Color.red);
			if(animation == 6 ) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
				g2.fillRect(133, 346, 6, 2);
				g2.fillRect(135, 344, 2, 6);
			}
			
			if(animation == 7 ) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
				g2.fillRect(178, 380, 6, 2);
				g2.fillRect(180, 378, 2, 6);
			}
			
			if(animation == 8 ) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
				g2.fillRect(148, 389, 6, 2);
				g2.fillRect(150, 387, 2, 6);
			}
			
			if(animation == 9 ) {
				g2.drawImage(wbronya, worldX, worldY, 125, 100, null);
				g2.fillRect(172, 345, 6, 2);
				g2.fillRect(174, 343, 2, 6);
			}
		}
	}
}
