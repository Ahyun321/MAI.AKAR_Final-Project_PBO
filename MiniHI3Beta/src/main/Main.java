package main;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Mini HI3 Beta");
				//Image icon = Toolkit.getDefaultToolkit().getImage("D:\\FP PBO\\tes icon.png");
				//frame.setIconImage(icon);
				
				GamePanel gamePanel = new GamePanel();
				frame.add(gamePanel);
				
				frame.pack();
				
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				
				gamePanel.setupGame();
				gamePanel.startGameThread();
				
	}
}
