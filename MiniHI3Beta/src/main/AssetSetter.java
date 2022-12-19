package main;

import entity.Enemies_Bio_JunNinja;
import entity.Enemies_Mech_Lightning;
import entity.Enemies_Psy_Chariot;
import entity.Enemies_Qua_Tonatiuh;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		
		this.gp = gp;
	}
	
	
	public void setEnemies() {
		
		gp.enemies[0] = new Enemies_Mech_Lightning(gp);
		gp.enemies[0].worldX = 200;
		gp.enemies[0].worldY = 200;
		
		gp.enemies[1] = new Enemies_Bio_JunNinja(gp);
		gp.enemies[1].worldX = 200;
		gp.enemies[1].worldY = 200;
		
		gp.enemies[2] = new Enemies_Psy_Chariot(gp);
		gp.enemies[2].worldX = 200;
		gp.enemies[2].worldY = 200;
		
		gp.enemies[3] = new Enemies_Qua_Tonatiuh(gp);
		gp.enemies[3].worldX = 200;
		gp.enemies[3].worldY = 200;
		
	}
}
