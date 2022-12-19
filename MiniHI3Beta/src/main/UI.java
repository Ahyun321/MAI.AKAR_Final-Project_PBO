package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	public int commandNum = 0;
	public int screenState = 0;
	public int turn = 0;
	public int loading = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		//Screen State
		if(gp.gameState == gp.screenState) {
			drawTitleScreen();
		}
		
		//Level state
		if(gp.gameState == gp.levelState) {
			drawLevelScreen();
		}
		
		//Play State
		if(gp.gameState == gp.playState) {
			drawPlayerHealth();
		}
		
		//Pause State
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		
		//Guide Screen
		if(gp.gameState == gp.guideState) {
			drawGuideScreen();
		}
		
		if(gp.gameState == gp.winState) {
			drawWinScreen();
		}
		
		if(gp.gameState == gp.loseState) {
			drawLoseScreen();
		}
	}
	
	public void drawPlayerHealth() {
		
		double oneScale = 300/gp.player.maxLife;
		double healthBarValue = oneScale*gp.player.life;
		g2.setColor(Color.red);
		g2.fillRect(20, 452, (int)healthBarValue, 15);
	}
	
	public void drawTitleScreen() {
		
		if(screenState == 0) {
			
			//Background
			int x = 0;
			int y = 0;
			g2.drawImage(gp.player.bg, x, y, 720, 480, null);
			
			//Title
			g2.setFont(new Font("Times New Roman",Font.BOLD,100));
			g2.setColor(Color.black);
			String text = "Mini HI3";
			x = getXforCenteredText(text);
			y = 80;
			g2.drawString(text, x, y);
			g2.drawString(text, x-6, y-6);
			g2.drawString(text, x, y-6);
			g2.drawString(text, x-6, y);
			g2.setColor(Color.white);
			g2.drawString(text, x-3, y-3);

			//ICON
			x = 285;
			y = 110;
			g2.drawImage(gp.player.icon, x, y, 150, 150, null);
				
			//SELECT
			g2.setFont(new Font("Times New Roman",Font.BOLD,30));
			g2.setColor(Color.black);
			text = "Select Menu";
			x = getXforCenteredText(text);
			y = 300;
			g2.drawString(text, x, y);
			g2.drawString(text, x-2, y-2);
			g2.drawString(text, x, y-2);
			g2.drawString(text, x-2, y);
			g2.setColor(Color.white);
			g2.drawString(text, x-1, y-1);
			//-------
			g2.setFont(new Font("Times New Roman",Font.BOLD,30));
			g2.setColor(Color.black);
			text = "_____________";
			x = getXforCenteredText(text);
			y = 310;
			g2.drawString(text, x, y);
			
			//MENU
			g2.setFont(new Font("Times New Roman",Font.BOLD,40));
			g2.setColor(Color.black);
			text = "START";
			x = 60;
			y = 335;
			g2.setColor(Color.green);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(x, y, 150, 80, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.drawString(text, 70, 385);

			if (commandNum == 0) {
				g2.setColor(Color.white);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillRoundRect(x, y, 150, 80, 15, 15);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.white);
				g2.drawString(text, 70, 385);
				g2.setColor(Color.green);
				g2.drawRoundRect(x-2, y-2, 154, 84, 15, 15);
				
			}

			g2.setFont(new Font("Times New Roman",Font.BOLD,40));
			g2.setColor(Color.black);
			text = "GUIDE";
			x = 285;
			y = 335;
			g2.setColor(Color.gray);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(x, y, 150, 80, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.drawString(text, 295, 385);
			if(commandNum == 1) {
				g2.setColor(Color.white);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillRoundRect(x, y, 150, 80, 15, 15);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.white);
				g2.drawString(text, 295, 385);
				g2.setColor(Color.gray);
				g2.drawRoundRect(x-2, y-2, 154, 84, 15, 15);
			}
			
			g2.setFont(new Font("Times New Roman",Font.BOLD,40));
			g2.setColor(Color.black);
			text = "QUIT";
			x = 510;
			y = 335;
			g2.setColor(Color.red);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(x, y, 150, 80, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.drawString(text, 535, 385);
			if (commandNum == 2) {
				g2.setColor(Color.white);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillRoundRect(x, y, 150, 80, 15, 15);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.white);
				g2.drawString(text, 535, 385);
				g2.setColor(Color.red);
				g2.drawRoundRect(x-2, y-2, 154, 84, 15, 15);
			}

			
			g2.setColor(Color.BLACK);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
			g2.fillRect(0, 460, 720, 480);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("A and D for Control              ENTER for Select", 10, 473);
			
		}
		else if(screenState == 1) {
			

			g2.drawImage(gp.player.hyperion, 0, 0, 720, 480, null);
			g2.setColor(Color.DARK_GRAY);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(100, 10, 520, 60, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			
			g2.setFont(new Font("Times New Roman",Font.BOLD,50));
			g2.setColor(Color.black);
			
			String text = "Select Valkyrie :";
			int x = getXforCenteredText(text);
			int y = 57;
			g2.drawString(text, x, y);
			g2.drawString(text, x-4, y-4);
			g2.drawString(text, x, y-4);
			g2.drawString(text, x-4, y);
			g2.setColor(Color.white);
			g2.drawString(text, x-2, y-2);
			
			text = "Kiana";
			g2.setColor(Color.black);
			g2.setFont(new Font("Times New Roman",Font.BOLD,25));
			x = getXforCenteredText(text);
			y = 200;
			g2.setColor(Color.WHITE);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(20, 80, 330, 140, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.black);
			g2.fillRoundRect(38, 98, 104, 104, 15, 15);
			g2.setColor(Color.green);
			g2.fillRoundRect(40, 100, 100, 100, 15, 15);
			g2.drawImage(gp.player.kiana, 3, 80, 175, 140, null);
			g2.setColor(Color.cyan);
			g2.fillOval(155, 100, 20, 20);
			g2.drawString("Kiana Kaslana", 155, 150);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("Kiana Kaslana is the daughter of Cecilia", 155, 170);
			g2.drawString("Schariac & Siegfried Kaslana. She is", 155, 180);
			g2.drawString("currently enrolled at St. Freya High", 155, 190);
			g2.drawString("School as a Valkyrie alongside Raiden", 155, 200);
			g2.drawString("Mei and Bronya Zaychik.", 155, 210);

			if(commandNum == 0) {
				g2.setFont(new Font("Times New Roman",Font.BOLD,25));
				g2.setColor(Color.cyan);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillRoundRect(20, 80, 330, 140, 15, 15);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.black);
				g2.fillRoundRect(38, 98, 104, 104, 15, 15);
				g2.setColor(Color.green);
				g2.fillRoundRect(40, 100, 100, 100, 15, 15);
				g2.drawImage(gp.player.wkiana, 3, 80, 175, 140, null);
				g2.setColor(Color.cyan);
				g2.fillOval(155, 100, 20, 20);
				g2.setColor(Color.white);
				g2.drawString("Kiana Kaslana", 155, 150);
				g2.setFont(new Font("Times New Roman",Font.BOLD,10));
				g2.drawString("Kiana Kaslana is the daughter of Cecilia", 155, 170);
				g2.drawString("Schariac & Siegfried Kaslana. She is", 155, 180);
				g2.drawString("currently enrolled at St. Freya High", 155, 190);
				g2.drawString("School as a Valkyrie alongside Raiden", 155, 200);
				g2.drawString("Mei and Bronya Zaychik.", 155, 210);
			}
			
			text = "Mei";
			g2.setColor(Color.black);
			g2.setFont(new Font("Times New Roman",Font.BOLD,25));
			x = getXforCenteredText(text);
			y = 240;
			g2.setColor(Color.WHITE);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(20, 240, 330, 140, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.black);
			g2.fillRoundRect(38, 258, 104, 104, 15, 15);
			g2.setColor(Color.green);
			g2.fillRoundRect(40, 260, 100, 100, 15, 15);
			g2.drawImage(gp.player.mei, 3, 240, 175, 140, null);
			g2.setColor(Color.orange);
			g2.fillOval(155, 260, 20, 20);
			g2.drawString("Raiden Mei", 155, 310);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("Raiden Mei is the beautiful and demure", 155, 330);
			g2.drawString("daughter of the prominent Raiden Ryoma.", 155, 340);
			g2.drawString("Combined with her mastery of Bushido", 155, 350);
			g2.drawString("and Itto-ryu, this makes her a true ", 155, 360);
			g2.drawString("incarnation of silk hiding steel.", 155, 370);
			
			if(commandNum == 1) {
				g2.setFont(new Font("Times New Roman",Font.BOLD,25));
				g2.setColor(Color.cyan);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillRoundRect(20, 240, 330, 140, 15, 15);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.black);
				g2.fillRoundRect(38, 258, 104, 104, 15, 15);
				g2.setColor(Color.green);
				g2.fillRoundRect(40, 260, 100, 100, 15, 15);
				g2.drawImage(gp.player.wmei, 3, 240, 175, 140, null);
				g2.setColor(Color.orange);
				g2.fillOval(155, 260, 20, 20);
				g2.setColor(Color.white);
				g2.drawString("Raiden Mei", 155, 310);
				g2.setFont(new Font("Times New Roman",Font.BOLD,10));
				g2.drawString("Raiden Mei is the beautiful and demure", 155, 330);
				g2.drawString("daughter of the prominent Raiden Ryoma.", 155, 340);
				g2.drawString("Combined with her mastery of Bushido", 155, 350);
				g2.drawString("and Itto-ryu, this makes her a true ", 155, 360);
				g2.drawString("incarnation of silk hiding steel.", 155, 370);
			}
			
			text = "Bronya";
			g2.setColor(Color.black);
			g2.setFont(new Font("Times New Roman",Font.BOLD,25));
			x = getXforCenteredText(text);
			y = 280;
			
			g2.setColor(Color.WHITE);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(370, 80, 330, 140, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.black);
			g2.fillRoundRect(388, 98, 104, 104, 15, 15);
			g2.setColor(Color.green);
			g2.fillRoundRect(390, 100, 100, 100, 15, 15);
			g2.drawImage(gp.player.bronya, 353, 80, 175, 140, null);
			g2.setColor(Color.MAGENTA);
			g2.fillOval(505, 100, 20, 20);
			g2.drawString("Bronya Zaychik", 505, 150);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("As the youngest of her classmates, Bronya", 505, 170);
			g2.drawString("has a short and slim stature with piercing", 505, 180);
			g2.drawString("silver eyes. She keeps her silver-gray", 505, 190);
			g2.drawString("hair tied up in signature double pigtails in", 505, 200);
			g2.drawString("a shape and includes a matching ribbon.", 505, 210);
			
			if(commandNum == 2) {
				g2.setFont(new Font("Times New Roman",Font.BOLD,25));
				g2.setColor(Color.cyan);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillRoundRect(370, 80, 330, 140, 15, 15);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.black);
				g2.fillRoundRect(388, 98, 104, 104, 15, 15);
				g2.setColor(Color.green);
				g2.fillRoundRect(390, 100, 100, 100, 15, 15);
				g2.drawImage(gp.player.bronyacut, 353, 80, 175, 140, null);
				g2.setColor(Color.MAGENTA);
				g2.fillOval(505, 100, 20, 20);
				g2.setColor(Color.white);
				g2.drawString("Bronya Zaychik", 505, 150);
				g2.setFont(new Font("Times New Roman",Font.BOLD,10));
				g2.drawString("As the youngest of her classmates, Bronya", 505, 170);
				g2.drawString("has a short and slim stature with piercing", 505, 180);
				g2.drawString("silver eyes. She keeps her silver-gray", 505, 190);
				g2.drawString("hair tied up in signature double pigtails in", 505, 200);
				g2.drawString("a shape and includes a matching ribbon.", 505, 210);
			}
			
			g2.setFont(new Font("Times New Roman",Font.BOLD,75));
			g2.setColor(Color.DARK_GRAY);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
			g2.fillRoundRect(370, 240, 330, 140, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.drawString("?", 520, 330);
			
			g2.setColor(Color.BLACK);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
			g2.fillRect(0, 460, 720, 480);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("W, A, S, D for Control              ENTER for Select", 10, 473);
			
			g2.setColor(Color.WHITE);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(240, 400, 240, 40, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			text = "BACK";
			g2.setFont(new Font("Times New Roman",Font.BOLD,25));
			x = getXforCenteredText(text);
			y = 430;
			g2.setColor(Color.DARK_GRAY);
			g2.drawString(text, x, y);
			if(commandNum == 3) {
				g2.setColor(Color.CYAN);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
				g2.fillRoundRect(240, 400, 240, 40, 15, 15);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
				g2.setColor(Color.WHITE);
				g2.drawString(text, x, y);
			}
			
		}
		
	}
	public void drawGuideScreen() {
		
		g2.drawImage(gp.player.guide, -5, 0, 725, 480, null);
	}
	
	public void drawLevelScreen() {
		
		g2.drawImage(gp.player.hyperion, 0, 0, 720, 480, null);
		g2.setColor(Color.DARK_GRAY);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
		g2.fillRoundRect(100, 10, 520, 60, 15, 15);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
		
		g2.setFont(new Font("Times New Roman",Font.BOLD,50));
		g2.setColor(Color.black);
		
		String text = "Select Level :";
		int x = getXforCenteredText(text);
		int y = 57;
		g2.drawString(text, x, y);
		g2.drawString(text, x-4, y-4);
		g2.drawString(text, x, y-4);
		g2.drawString(text, x-4, y);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y-2);
		g2.setFont(new Font("Times New Roman",Font.BOLD,50));
		
		g2.setColor(Color.white);
		if(commandNum == 0) {
			g2.fillRect(212, 87, 96, 96);
		}
		if(commandNum == 1) {
			g2.fillRect(412, 87, 96, 96);
		}
		if(commandNum == 2) {
			g2.fillRect(112, 187, 96, 96);
		}
		if(commandNum == 3) {
			g2.fillRect(312, 187, 96, 96);
		}
		if(commandNum == 4) {
			g2.fillRect(512, 187, 96, 96);
		}
		if(commandNum == 5) {
			g2.fillRect(212, 287, 96, 96);
		}
		if(commandNum == 6) {
			g2.fillRect(412, 287, 96, 96);
		}
		
		g2.setColor(Color.black);
		g2.drawImage(gp.player.icon2,215, 90, 90, 90, null);	
		g2.drawImage(gp.player.icon2,415, 90, 90, 90, null);	
		g2.drawImage(gp.player.icon2,115, 190, 90, 90, null);
		g2.drawImage(gp.player.icon2,315, 190, 90, 90, null);
		g2.drawImage(gp.player.icon2,515, 190, 90, 90, null);
		g2.drawImage(gp.player.icon2,215, 290, 90, 90, null);
		g2.drawImage(gp.player.icon2,415, 290, 90, 90, null);
		
		g2.drawString("1", 250, 152);
		g2.drawString("2", 450, 152);
		g2.drawString("3", 150, 252);
		g2.drawString("4", 350, 252);
		g2.drawString("5", 550, 252);
		g2.drawString("6", 250, 352);
		g2.drawString("7", 450, 352);
		g2.setColor(Color.CYAN);
		g2.drawString("1", 248, 150);
		g2.drawString("4", 348, 250);
		g2.setColor(Color.ORANGE);
		g2.drawString("2", 448, 150);
		g2.drawString("5", 548, 250);
		g2.setColor(Color.MAGENTA);
		g2.drawString("3", 148, 250);
		g2.drawString("6", 248, 350);
		g2.setColor(new Color(136, 111, 246));
		g2.drawString("7", 448, 350);
		
		g2.setColor(Color.WHITE);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
		g2.fillRoundRect(240, 400, 240, 40, 15, 15);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
		text = "BACK";
		g2.setFont(new Font("Times New Roman",Font.BOLD,25));
		x = getXforCenteredText(text);
		y = 430;
		g2.setColor(Color.DARK_GRAY);
		g2.drawString(text, x, y);
		if(commandNum == 7) {
			g2.setColor(Color.CYAN);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
			g2.fillRoundRect(240, 400, 240, 40, 15, 15);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.WHITE);
			g2.drawString(text, x, y);
		}
		
		g2.setColor(Color.BLACK);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
		g2.fillRect(0, 460, 720, 480);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
		g2.setColor(Color.white);
		g2.setFont(new Font("Times New Roman",Font.BOLD,10));
		g2.drawString("A and D for Control              ENTER for Select", 10, 473);
		
		if(loading == 1) {
			g2.drawImage(gp.player.hyperion, 0, 0, 720, 480, null);
			g2.setFont(new Font("Times New Roman",Font.BOLD,100));
			g2.setColor(Color.black);
			text = "Loading .";
			x = getXforCenteredText(text);
			y = 260;
			g2.drawString(text, x, y);
			g2.drawString(text, x-6, y-6);
			g2.drawString(text, x, y-6);
			g2.drawString(text, x-6, y);
			g2.setColor(Color.white);
			g2.drawString(text, x-3, y-3);
			
			g2.setColor(Color.BLACK);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
			g2.fillRect(0, 460, 720, 480);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("Z  for Attacking, X  for Healing, C  for Ultimate, ESC  for Pausing", 10, 473);
			g2.drawString("Ultimate will triggered after you attack 5 times", 505, 473);
		}
		
		if(loading == 2) {
			g2.drawImage(gp.player.hyperion, 0, 0, 720, 480, null);
			g2.setFont(new Font("Times New Roman",Font.BOLD,100));
			g2.setColor(Color.black);
			text = "Loading . .";
			x = getXforCenteredText(text);
			y = 260;
			g2.drawString(text, x, y);
			g2.drawString(text, x-6, y-6);
			g2.drawString(text, x, y-6);
			g2.drawString(text, x-6, y);
			g2.setColor(Color.white);
			g2.drawString(text, x-3, y-3);
			
			g2.setColor(Color.BLACK);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
			g2.fillRect(0, 460, 720, 480);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("Z  for Attacking, X  for Healing, C  for Ultimate, ESC  for Pausing", 10, 473);
			g2.drawString("Ultimate will triggered after you attack 5 times", 505, 473);
		}
		
		if(loading == 3) {
			g2.drawImage(gp.player.hyperion, 0, 0, 720, 480, null);
			g2.setFont(new Font("Times New Roman",Font.BOLD,100));
			g2.setColor(Color.black);
			text = "Loading . . .";
			x = getXforCenteredText(text);
			y = 260;
			g2.drawString(text, x, y);
			g2.drawString(text, x-6, y-6);
			g2.drawString(text, x, y-6);
			g2.drawString(text, x-6, y);
			g2.setColor(Color.white);
			g2.drawString(text, x-3, y-3);
			
			g2.setColor(Color.BLACK);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.75f));
			g2.fillRect(0, 460, 720, 480);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1f));
			g2.setColor(Color.white);
			g2.setFont(new Font("Times New Roman",Font.BOLD,10));
			g2.drawString("Z  for Attacking, X  for Healing, C  for Ultimate, ESC  for Pausing", 10, 473);
			g2.drawString("Ultimate will triggered after you attack 5 times", 505, 473);
		}
	}
	
	public void drawWinScreen() {
		
		g2.drawImage(gp.player.bg2, 0, 0, 720, 480, null);
		g2.setFont(new Font("Times New Roman",Font.BOLD,100));
		String text = "You Win";
		int x = getXforCenteredText(text);;
		int y = 220;
		
		g2.setColor(Color.black);
		g2.drawString(text, x, y);
		g2.drawString(text, x-6, y-6);
		g2.drawString(text, x, y-6);
		g2.drawString(text, x-6, y);
		g2.setColor(Color.white);
		g2.drawString(text, x-3, y-3);
		g2.setFont(new Font("Times New Roman",Font.BOLD,25));
		text = "Press BACKSPACE To Go Back To The Game Menu";
		x = getXforCenteredText(text);
		g2.setColor(Color.black);
		g2.drawString(text, x, y + 120);
		g2.drawString(text, x-4, y+118);
		g2.drawString(text, x, y+118);
		g2.drawString(text, x-4, y + 118);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y+119);
		text = "Press ENTER To Exit The Game";
		x = getXforCenteredText(text);
		g2.setColor(Color.black);
		g2.drawString(text, x, y + 160);
		g2.drawString(text, x-4, y+158);
		g2.drawString(text, x, y+158);
		g2.drawString(text, x-4, y + 158);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y+159);
		
		x = 280;
		turn = gp.KeyP.turn - 1;
		g2.setColor(Color.black);
		g2.drawString("At Turns : "+turn, x, y + 40);
		g2.drawString("At Turns : "+turn, x-4, y+38);
		g2.drawString("At Turns : "+turn, x, y+38);
		g2.drawString("At Turns : "+turn, x-4, y + 38);
		g2.setColor(Color.white);
		g2.drawString("At Turns : "+turn, x-2, y+39);
	}
	
	public void drawLoseScreen() {
		
		g2.drawImage(gp.player.bg2, 0, 0, 720, 480, null);
		g2.setFont(new Font("Times New Roman",Font.BOLD,100));
		String text = "You Lose";
		int x = getXforCenteredText(text);;
		int y = 220;
		
		
		g2.setColor(Color.black);
		g2.drawString(text, x, y);
		g2.drawString(text, x-6, y-6);
		g2.drawString(text, x, y-6);
		g2.drawString(text, x-6, y);
		g2.setColor(Color.white);
		g2.drawString(text, x-3, y-3);
		g2.setFont(new Font("Times New Roman",Font.BOLD,25));
		text = "Press BACKSPACE To Go Back To The Game Menu";
		x = getXforCenteredText(text);
		g2.setColor(Color.black);
		g2.drawString(text, x, y + 120);
		g2.drawString(text, x-4, y+118);
		g2.drawString(text, x, y+118);
		g2.drawString(text, x-4, y + 118);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y+119);
		text = "Press ENTER To Exit The Game";
		x = getXforCenteredText(text);
		g2.setColor(Color.black);
		g2.drawString(text, x, y + 160);
		g2.drawString(text, x-4, y+158);
		g2.drawString(text, x, y+158);
		g2.drawString(text, x-4, y + 158);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y+159);
	}
	
	public void drawPauseScreen() {
		
		g2.drawImage(gp.player.bg2, 0, 0, 720, 480, null);
		String text = "Paused";
		int x = 200;
		int y = 220;
		
		g2.setFont(new Font("Times New Roman",Font.BOLD,100));
		g2.setColor(Color.black);
		g2.drawString(text, x, y);
		g2.drawString(text, x-6, y-6);
		g2.drawString(text, x, y-6);
		g2.drawString(text, x-6, y);
		g2.setColor(Color.white);
		g2.drawString(text, x-3, y-3);
		g2.setFont(new Font("Times New Roman",Font.BOLD,25));
		text = "Press ESC To Continue The Game";
		x = getXforCenteredText(text);	
		g2.setColor(Color.black);
		g2.drawString(text, x, y + 80);
		g2.drawString(text, x-4, y+78);
		g2.drawString(text, x, y+78);
		g2.drawString(text, x-4, y + 78);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y+79);
		text = "Press BACKSPACE To Go Back To The Game Menu";
		x = getXforCenteredText(text);
		g2.setColor(Color.black);
		g2.drawString(text, x, y + 120);
		g2.drawString(text, x-4, y+118);
		g2.drawString(text, x, y+118);
		g2.drawString(text, x-4, y + 118);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y+119);
		text = "Press ENTER To Exit The Game";
		x = getXforCenteredText(text);
		g2.setColor(Color.black);
		g2.drawString(text, x, y + 160);
		g2.drawString(text, x-4, y+158);
		g2.drawString(text, x, y+158);
		g2.drawString(text, x-4, y + 158);
		g2.setColor(Color.white);
		g2.drawString(text, x-2, y+159);
	}
	
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = 360 - length/2;
		return x;
	}
	
}
