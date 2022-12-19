package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyPanel;

public class Entity extends KeyPanel{

	GamePanel gp;
	public int worldX , worldY;
	
	public BufferedImage guide, icon, bg, hyperion, icon2, bg2;
	public BufferedImage kiana, wkiana, mei, wmei, bronya, wbronya, bronyacut;
	public BufferedImage b_heal, b_attack_kiana, b_attack_mei, b_attack_bronya;
	public BufferedImage b_ulti_kiana, b_ulti_mei, b_ulti_bronya;
	public BufferedImage kiana_ulti1, kiana_ulti2, kiana_ulti3, kiana_ulti4, kiana_ulti5, kiana_ulti6;
	public BufferedImage ani_mei_attack1, ani_mei_attack2, mei_ulti1, mei_ulti2;
	public BufferedImage ani_bronya_attack1, ani_bronya_attack2, bronya_ulti1, bronya_ulti2, bronya_ulti3, bronya_ulti4;
	public BufferedImage Chariot, JunNinja, Lightning, Tonatiuh;
	public BufferedImage DChariot, DJunNinja, DLightning, DTonatiuh;
	public BufferedImage DKiana, DMei, DBronya;
	public BufferedImage AJunNinja, QAttack;
	
	public int maxLife;
	public int life;
	
	public Entity(GamePanel gp) {
		super (gp);
		this.gp = gp;
	}
	
	public void draw(Graphics2D g2) {

	}

	public void update() {
		// TODO Auto-generated method stub
	}
}
