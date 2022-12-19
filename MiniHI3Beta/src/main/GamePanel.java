package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import background.bgmanager;
import entity.Entity;
import entity.Player;

public class GamePanel extends JPanel implements Runnable{
	
	//Screen Setting
	private int areaWidth = 720;
	private int areaHeight = 480;
	
	bgmanager bgmanage = new bgmanager(this);
	KeyPanel KeyP = new KeyPanel(this);
	music amusic = new music();
	music se = new music();
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	
	//Entity
	public Player player = new Player(this, KeyP);
	public Entity enemies[] = new Entity[10];
	ArrayList<Entity> entityList = new ArrayList<>();
	
	
	//Game state
	public int gameState;
	public final int screenState = 0;
	public final int hyperionState = 1;
	public final int levelState = 2;
	public final int playState = 3;
	public final int pauseState = 4;
	public final int winState = 5;
	public final int loseState = 6;
	public final int guideState = 7;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(areaWidth, areaHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyP);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		
		aSetter.setEnemies();
		playMusic(0);
		
		gameState = screenState;
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/60;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null) {
			
			update();
			repaint();
					
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}	
	}
	
	public void update() {

		if(gameState == playState) {
			player.update();
			
			for(int i = 0; i < enemies.length; i++) {
				if(enemies[i] != null) {
					enemies[i].update();
				}
			}
		}

	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//Screen State
		if (gameState == screenState) {
			ui.draw(g2);
		}
		//Others
		else {
			
			bgmanage.draw(g2);
			
			//Player
			entityList.add(player);
			
			for(int i = 0; i < enemies.length; i++) {
				if(enemies[i] != null) {
					entityList.add(enemies[i]);
				}
			}
			
			Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {

					int result = Integer.compare(e1.worldY, e2.worldY);
					return result;
				}
				
			});
			
			for(int i = 0; i < entityList.size(); i++) {
				
				entityList.get(i).draw(g2);
			}
			
			for(int i = 0; i < entityList.size(); i++) {
				
				entityList.remove(i);
			}
			
			ui.draw(g2);
		}

		g2.dispose();
	}
	
	public void playMusic(int i) {
		
		amusic.setFile(i);
		amusic.play();
		amusic.loop();
	}
	
	public void stopMusic() {
		amusic.stop();
	}
	
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
	}
}
