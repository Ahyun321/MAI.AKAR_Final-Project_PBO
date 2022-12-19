package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class KeyPanel implements KeyListener{
	
	GamePanel gp;
	public int turn = 0;
	public static int character = 0;
	public static int button = 0;
	public static int animation = 0;
	public static int enemie = 0;
	public static int ultimate = 0;
	public static int aniulti = 0;
	public int hold = 0;

	public KeyPanel(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Merandom sound effect character
		Random rand = new Random();
		int kianaintro = rand.nextInt(2, 6);
		int kianauhuk = rand.nextInt(7, 9);
		int meiintro = rand.nextInt(11, 13);
		int meiuhuk = rand.nextInt(14, 17);
		int bronyaintro = rand.nextInt(19, 22);
		int bronyauhuk = rand.nextInt(22, 24);
		
		int code = e.getKeyCode();
		
		//Screen State
		if(gp.gameState == gp.screenState) {
			
			if(gp.ui.screenState == 0) {
				
				if(code == KeyEvent.VK_A) {
					
					gp.ui.commandNum--;
					gp.playSE(27);
					
					if(gp.ui.commandNum < 0) gp.ui.commandNum = 2;
				}													
				
				if(code == KeyEvent.VK_D) {
					
					gp.ui.commandNum++;
					gp.playSE(27);
					
					if(gp.ui.commandNum > 2) gp.ui.commandNum = 0;
				}												
				
				if(code == KeyEvent.VK_ENTER) {					
					
					gp.playSE(27);
					
					if(gp.ui.commandNum == 0) gp.ui.screenState = 1;
						
					//Ketika GUIDE, lanjut ke layar Guide
					if(gp.ui.commandNum == 1) gp.gameState = gp.guideState;	
									
					if(gp.ui.commandNum == 2) System.exit(0);				
				}			
			}
			
			//Hyperion State
			else if(gp.ui.screenState == 1) {
				
				if(code == KeyEvent.VK_W) {							
					
					gp.ui.commandNum--;
					character--;
					gp.playSE(27);
					
					if(gp.ui.commandNum < 0) {						
						gp.ui.commandNum = 3;						
						character = 3;
					}
				}
				
				if(gp.ui.commandNum == 2) {							
					
					if(code == KeyEvent.VK_D) {					
						
						gp.ui.commandNum = 0;						
						character = 0;
						gp.playSE(27);
					}
				}
				
				else {
					
					if(code == KeyEvent.VK_D) {						
						
						gp.ui.commandNum = 2;
						character = 2;
						gp.playSE(27);
					}
				}	
				
				if(code == KeyEvent.VK_S) {							
					
					gp.ui.commandNum++;
					character++;
					gp.playSE(27);
					
					if(gp.ui.commandNum > 3) {						
																
						gp.ui.commandNum = 0;
						character = 0;
					}
				}
				
				if(gp.ui.commandNum == 0 || gp.ui.commandNum == 1) {
																	
					if(code == KeyEvent.VK_A) {					
						
						gp.ui.commandNum = 2;						
						character = 2;
						gp.playSE(27);
					}
				}
				
				else {
					
					if(code == KeyEvent.VK_A) {					
						
						gp.ui.commandNum = 0;
						character = 0;
						gp.playSE(27);
					}
				}
				
				if(code == KeyEvent.VK_BACK_SPACE) {				
					
					gp.ui.screenState = 0;
					character = 0;
					gp.ui.commandNum = 0;
					gp.playSE(27);
				}
				
				if(code == KeyEvent.VK_ENTER) {						
					
					gp.playSE(27);
					
					if(gp.ui.commandNum == 0 || gp.ui.commandNum == 1 || gp.ui.commandNum == 2) 
						gp.gameState = gp.levelState;
					
					if(gp.ui.commandNum == 3) gp.ui.screenState = 0;
																	
					gp.ui.commandNum = 0;
				}		
			}	
		}
		
		//Guide State
		else if(gp.gameState == gp.guideState) {
			
			if(code == KeyEvent.VK_BACK_SPACE) {				
																
				gp.gameState = gp.screenState;
				gp.ui.commandNum = 0;
				gp.playSE(27);
			}
		}
		
		//Level State
		else if(gp.gameState == gp.levelState) {
			
			if(code == KeyEvent.VK_D) {							
				
				gp.ui.commandNum++;
				gp.playSE(27);
				
				if(gp.ui.commandNum > 7) 						
					gp.ui.commandNum = 0;						
			}
			
			if(code == KeyEvent.VK_A) {								
				
				gp.ui.commandNum--;
				gp.playSE(27);
				
				if(gp.ui.commandNum < 0) 					
					gp.ui.commandNum = 7;						
			}
			
			if(code == KeyEvent.VK_BACK_SPACE) {				
																
				gp.gameState = gp.screenState;
				gp.ui.screenState = 1;
				character = 0;
				gp.ui.commandNum = 0;
				gp.playSE(27);
			}
			
			if(code == KeyEvent.VK_ENTER && hold == 0) {
				
				ultimate = 0;
				hold = 1;
				Timer holdtime = new Timer();
				holdtime.schedule(new TimerTask() {

					public void run() {
						hold = 0;
					}		
				}, 4000);
				
				if(gp.ui.commandNum != 7) {
					gp.playSE(29);
					gp.ui.loading = 1;
					
					Timer anilvl1time = new Timer();
					anilvl1time.schedule(new TimerTask() {

						@Override
						public void run() {
							gp.ui.loading = 2;
						}
						
					}, 750);
					
					Timer anilvl2time = new Timer();
					anilvl2time.schedule(new TimerTask() {

						@Override
						public void run() {
							gp.ui.loading = 3;
						}
						
					}, 1500);
				
					Timer anilvl3time = new Timer();
					anilvl3time.schedule(new TimerTask() {

						public void run() {
							if(gp.ui.commandNum == 0) {
								gp.gameState = gp.playState;
								gp.stopMusic();
								gp.playMusic(1);
								if(character == 0) {
									gp.player.life /= 5;
									gp.playSE(kianaintro);
								}
								if(character == 1) {
									gp.player.life /= 8;
									gp.playSE(meiintro);
								}
								if(character == 2) {
									gp.player.life /= 6;
									gp.playSE(bronyaintro);
								}
								gp.enemies[0].life /= 5;
								gp.enemies[1].life /= 5;
								gp.enemies[2].life /= 5;
								gp.enemies[3].life /= 5;
							}
							if(gp.ui.commandNum == 1) {
								gp.gameState = gp.playState;
								gp.stopMusic();
								gp.playMusic(1);
								if(character == 0) {
									gp.player.life /= 5;
									gp.playSE(kianaintro);
								}
								if(character == 1) {
									gp.player.life /= 8;
									gp.playSE(meiintro);
								}
								if(character == 2) {
									gp.player.life /= 6;
									gp.playSE(bronyaintro);
								}
								gp.enemies[0].life /= 4;
								gp.enemies[1].life /= 4;
								gp.enemies[2].life /= 4;
								gp.enemies[3].life /= 4;
								
							}
							if(gp.ui.commandNum == 2) {
								gp.gameState = gp.playState;
								gp.stopMusic();
								gp.playMusic(1);
								if(character == 0) {
									gp.player.life /= 5;
									gp.playSE(kianaintro);
								}
								if(character == 1) {
									gp.player.life /= 8;
									gp.playSE(meiintro);
								}
								if(character == 2) {
									gp.player.life /= 6;
									gp.playSE(bronyaintro);
								}
								gp.enemies[0].life /= 3;
								gp.enemies[1].life /= 3;
								gp.enemies[2].life /= 3;
								gp.enemies[3].life /= 3;
							}
							if(gp.ui.commandNum == 3) {
								gp.gameState = gp.playState;
								gp.stopMusic();
								gp.playMusic(1);
								if(character == 0) {
									gp.player.life /= 5;
									gp.playSE(kianaintro);
								}
								if(character == 1) {
									gp.player.life /= 8;
									gp.playSE(meiintro);
								}
								if(character == 2) {
									gp.player.life /= 6;
									gp.playSE(bronyaintro);
								}
								gp.enemies[0].life /= 2;
								gp.enemies[1].life /= 2;
								gp.enemies[2].life /= 2;
								gp.enemies[3].life /= 2;
							}
							if(gp.ui.commandNum == 4) {
								gp.gameState = gp.playState;
								gp.stopMusic();
								gp.playMusic(1);
								if(character == 0) {
									gp.player.life /= 5;
									gp.playSE(kianaintro);
								}
								if(character == 1) {
									gp.player.life /= 8;
									gp.playSE(meiintro);
								}
								if(character == 2) {
									gp.player.life /= 6;
									gp.playSE(bronyaintro);
								}
								
								gp.enemies[0].life = gp.enemies[0].life / 1 - 20;
								gp.enemies[1].life = gp.enemies[1].life / 1 - 20;
								gp.enemies[2].life = gp.enemies[2].life / 1 - 20;
								gp.enemies[3].life = gp.enemies[3].life / 1 - 20;
							}
							if(gp.ui.commandNum == 5) {
								gp.gameState = gp.playState;
								gp.stopMusic();
								gp.playMusic(1);
								if(character == 0) {
									gp.player.life /= 5;
									gp.playSE(kianaintro);
								}
								if(character == 1) {
									gp.player.life /= 8;
									gp.playSE(meiintro);
								}
								if(character == 2) {
									gp.player.life /= 6;
									gp.playSE(bronyaintro);
								}
								
								gp.enemies[0].life = gp.enemies[0].life / 1 - 10;
								gp.enemies[1].life = gp.enemies[1].life / 1 - 10;
								gp.enemies[2].life = gp.enemies[2].life / 1 - 10;
								gp.enemies[3].life = gp.enemies[3].life / 1 - 10;
							}
							if(gp.ui.commandNum == 6) {
								gp.gameState = gp.playState;
								gp.stopMusic();
								gp.playMusic(1);
								if(character == 0) {
									gp.player.life /= 5;
									gp.playSE(kianaintro);
								}
								if(character == 1) {
									gp.player.life /= 8;
									gp.playSE(meiintro);
								}
								if(character == 2) {
									gp.player.life /= 6;
									gp.playSE(bronyaintro);
								}
								
								gp.enemies[0].life /= 1;
								gp.enemies[1].life /= 1;
								gp.enemies[2].life /= 1;
								gp.enemies[3].life /= 1;
							}
							gp.ui.loading = 0;
						}			
					}, 2250);
				}
		
				if(gp.ui.commandNum == 7) {
					gp.gameState = gp.screenState;
					gp.ui.commandNum = 0;
				}
			}
		}
		
		//Play State
		if(code == KeyEvent.VK_Z && gp.gameState == gp.playState && hold == 0) {
			
			turn += 2;
			button = 1;
			ultimate++;
			hold = 1;
			Timer holdtime = new Timer();
			holdtime.schedule(new TimerTask() {

				public void run() {
					hold = 0;
				}		
			}, 1000);
			
			
			if(ultimate > 5) {
				ultimate = 5;
			}
			
			if(character == 0 && gp.player.life > 0) {
				gp.playSE(6);
			}
			
			if(character == 1 && gp.player.life > 0) {
				gp.playSE(13);
			}
			
			if(character == 2 && gp.player.life > 0) {
				gp.playSE(24);
			}
			
			Timer ani1time = new Timer();
			ani1time.schedule(new TimerTask() {

				public void run() {
					animation = 1;
				}		
			}, 100);
			
			Timer ani2time = new Timer();
			ani2time.schedule(new TimerTask() {

				public void run() {
					animation = 2;
				}			
			}, 200);
			
			Timer ani3time = new Timer();
			ani3time.schedule(new TimerTask() {

				public void run() {
					animation = 3;
				}				
			}, 300);
			
			Timer ani4time = new Timer();
			ani4time.schedule(new TimerTask() {

				public void run() {
					animation = 4;
				}			
			}, 400);
			
			Timer ani5time = new Timer();
			ani5time.schedule(new TimerTask() {

				public void run() {
					animation = 5;
				}			
			}, 500);
			
			Timer ani0time = new Timer();
			ani0time.schedule(new TimerTask() {

				public void run() {
					animation = 0;
				}				
			}, 600);
			
			Timer atime = new Timer();
			atime.schedule(new TimerTask() {

				public void run() {
					if(character == 0) {
						gp.enemies[0].life -= 2;
						gp.enemies[1].life -= 4;
						gp.enemies[2].life -= 2;
						gp.enemies[3].life -= 2;
					}
					if(character == 1) {
						gp.enemies[0].life -= 8;
						gp.enemies[1].life -= 8;
						gp.enemies[2].life -= 16;
						gp.enemies[3].life -= 8;
					}
					if(character == 2) {
						gp.enemies[0].life -= 8;
						gp.enemies[1].life -= 4;
						gp.enemies[2].life -= 4;
						gp.enemies[3].life -= 4;
					}
					
					if(gp.ui.commandNum == 0 || gp.ui.commandNum == 3) {
						if(gp.enemies[0].life < 1) {
							gp.gameState = gp.winState;
							if(character == 0) {
								gp.playSE(10);
							}
							if(character == 1) {
								gp.playSE(17);
							}
							if(character == 2) {
								gp.playSE(25);
							}
						}
					}

					if(gp.ui.commandNum == 1 || gp.ui.commandNum == 4) {
						if(gp.enemies[1].life < 1) {
							gp.gameState = gp.winState;
							if(character == 0) {
								gp.playSE(10);
							}
							if(character == 1) {
								gp.playSE(17);
							}
							if(character == 2) {
								gp.playSE(25);
							}
						}
					}

					if(gp.ui.commandNum == 2 || gp.ui.commandNum == 5) {
						if(gp.enemies[2].life < 1) {
							gp.gameState = gp.winState;
							if(character == 0) {
								gp.playSE(10);
							}
							if(character == 1) {
								gp.playSE(17);
							}
							if(character == 2) {
								gp.playSE(25);
							}
						}
					}
					
					if(gp.ui.commandNum == 6) {
						if(gp.enemies[3].life < 1) {
							gp.gameState = gp.winState;
							if(character == 0) {
								gp.playSE(10);
							}
							if(character == 1) {
								gp.playSE(17);
							}
							if(character == 2) {
								gp.playSE(25);
							}
						}
					}
				}			
			}, 500);
			
			Timer btime = new Timer();
			btime.schedule(new TimerTask() {

				public void run() {
					button = 0;			
				}				
			}, 150);
			
			Timer ene1time = new Timer();
			ene1time.schedule(new TimerTask() {

				public void run() {
					enemie = 1;			
				}				
			}, 600);
			
			Timer ene2time = new Timer();
			ene2time.schedule(new TimerTask() {

				public void run() {
					enemie = 2;			
				}				
			}, 700);
			
			Timer ene3time = new Timer();
			ene3time.schedule(new TimerTask() {

				public void run() {
					enemie = 3;			
				}	
			}, 800);
			
			Timer ene4time = new Timer();
			ene4time.schedule(new TimerTask() {

				public void run() {
					enemie = 4;			
				}			
			}, 900);
			
			Timer ene5time = new Timer();
			ene5time.schedule(new TimerTask() {

				public void run() {
					enemie = 5;		
				}				
			}, 1000);
			
			Timer ene0time = new Timer();
			ene0time.schedule(new TimerTask() {

				public void run() {
					enemie = 0;			
				}
			}, 1100);
			
			Timer time = new Timer();
			time.schedule(new TimerTask() {

				public void run() {
					if(gp.ui.commandNum == 0 || gp.ui.commandNum == 3) {
						if(character == 1) {
							if(gp.enemies[0].life > 0) {
								gp.player.life -= 4;
							}
						}else {
							if(gp.enemies[0].life > 0) {
								gp.player.life -= 2;
							}
						}
					}

					if(gp.ui.commandNum == 1 || gp.ui.commandNum == 4) {
						if(character == 2) {
							if(gp.enemies[1].life > 0) {
								gp.player.life -= 4;
							}
						}else {
							if(gp.enemies[1].life > 0) {
								gp.player.life -= 2;
							}
						}
					}

					if(gp.ui.commandNum == 2 || gp.ui.commandNum == 5) {
						if(character == 0) {
							if(gp.enemies[2].life > 0) {
								gp.player.life -= 4;
							}
						}else {
							if(gp.enemies[2].life > 0) {
								gp.player.life -= 2;
							}
						}
					}
					
					if(gp.ui.commandNum == 6) {
						if(gp.enemies[3].life > 0) {
							gp.player.life -= 2;
						}
					}
	
					if(gp.player.life < 1) {
						gp.gameState = gp.loseState;
						if(character == 0 && code != KeyEvent.VK_BACK_SPACE && code != KeyEvent.VK_ENTER ) {
							gp.playSE(kianauhuk);
						}
						if(character == 1 && code != KeyEvent.VK_BACK_SPACE && code != KeyEvent.VK_ENTER ) {
							gp.playSE(meiuhuk);
						}
						if(character == 2 && code != KeyEvent.VK_BACK_SPACE && code != KeyEvent.VK_ENTER ) {
							gp.playSE(bronyauhuk);
						}
					}
				}		
			}, 1000);
		}
		
		if(code == KeyEvent.VK_X && gp.gameState == gp.playState && hold == 0) {
			
			gp.player.life += 3;
			turn += 2;
			hold = 1;
			Timer holdtime = new Timer();
			holdtime.schedule(new TimerTask() {

				public void run() {
					hold = 0;
				}		
			}, 1000);
			
			gp.playSE(30);
			if(gp.player.life > gp.player.maxLife) {
				gp.player.life = gp.player.maxLife;
			}
			button = 2;
			
			Timer btime = new Timer();
			btime.schedule(new TimerTask() {

				public void run() {
					button = 0;			
				}			
			}, 150);
			
			Timer ani6time = new Timer();
			ani6time.schedule(new TimerTask() {

				public void run() {
					animation = 6;
				}			
			}, 100);
			
			Timer ani7time = new Timer();
			ani7time.schedule(new TimerTask() {

				public void run() {
					animation = 7;
				}			
			}, 250);
			
			Timer ani8time = new Timer();
			ani8time.schedule(new TimerTask() {

				public void run() {
					animation = 8;
				}				
			}, 400);
			
			Timer ani9time = new Timer();
			ani9time.schedule(new TimerTask() {

				public void run() {
					animation = 9;
				}				
			}, 550);
			
			Timer ani0time = new Timer();
			ani0time.schedule(new TimerTask() {

				public void run() {
					animation = 0;
				}				
			}, 700);
			
			Timer ene2time = new Timer();
			ene2time.schedule(new TimerTask() {

				public void run() {
					enemie = 2;			
				}				
			}, 700);
			
			Timer ene3time = new Timer();
			ene3time.schedule(new TimerTask() {

				public void run() {
					enemie = 3;			
				}				
			}, 800);
			
			Timer ene4time = new Timer();
			ene4time.schedule(new TimerTask() {

				public void run() {
					enemie = 4;			
				}				
			}, 900);
			
			Timer ene5time = new Timer();
			ene5time.schedule(new TimerTask() {

				public void run() {
					enemie = 5;			
				}				
			}, 1000);
			
			Timer ene0time = new Timer();
			ene0time.schedule(new TimerTask() {

				public void run() {
					enemie = 0;			
				}				
			}, 1100);
			
			Timer time = new Timer();
			time.schedule(new TimerTask() {

				public void run() {
					if(gp.ui.commandNum == 0 || gp.ui.commandNum == 3) {
						if(character == 1) {
							if(gp.enemies[0].life > 0) {
								gp.player.life -= 4;
							}
						}else {
							if(gp.enemies[0].life > 0) {
								gp.player.life -= 2;
							}
						}
					}

					if(gp.ui.commandNum == 1 || gp.ui.commandNum == 4) {
						if(character == 2) {
							if(gp.enemies[1].life > 0) {
								gp.player.life -= 4;
							}
						}else {
							if(gp.enemies[1].life > 0) {
								gp.player.life -= 2;
							}
						}
					}

					if(gp.ui.commandNum == 2 || gp.ui.commandNum == 5) {
						if(character == 0) {
							if(gp.enemies[2].life > 0) {
								gp.player.life -= 4;
							}
						}else {
							if(gp.enemies[2].life > 0) {
								gp.player.life -= 2;
							}
						}
					}
					
					if(gp.ui.commandNum == 6) {
						if(gp.enemies[3].life > 0) {
							gp.player.life -= 2;
						}
					}
					if(gp.player.life < 1) {
						gp.gameState = gp.loseState;
						if(character == 0 && code != KeyEvent.VK_BACK_SPACE && code != KeyEvent.VK_ENTER ) {
							gp.playSE(kianauhuk);
						}
						if(character == 1 && code != KeyEvent.VK_BACK_SPACE && code != KeyEvent.VK_ENTER ) {
							gp.playSE(meiuhuk);
						}
						if(character == 2 && code != KeyEvent.VK_BACK_SPACE && code != KeyEvent.VK_ENTER ) {
							gp.playSE(bronyauhuk);
						}
					}
				}			
			}, 1000);
		}
		
		if(code == KeyEvent.VK_C && gp.gameState == gp.playState) {
			if(ultimate % 5 == 0 && ultimate != 0) {
				turn += 2;
				ultimate = 0;
				
				if(character == 0 && gp.player.life > 0) {
					gp.playSE(9);
				}
				
				if(character == 1 && gp.player.life > 0) {
					gp.playSE(18);
				}
				
				if(character == 2 && gp.player.life > 0) {
					gp.playSE(26);
				}
				
				Timer ani1time = new Timer();
				ani1time.schedule(new TimerTask() {

					public void run() {
						aniulti = 1;
					}		
				}, 100);
				
				Timer ani2time = new Timer();
				ani2time.schedule(new TimerTask() {

					public void run() {
						aniulti = 2;
					}			
				}, 200);
				
				Timer ani3time = new Timer();
				ani3time.schedule(new TimerTask() {

					public void run() {
						aniulti = 3;
					}				
				}, 300);
				
				Timer ani4time = new Timer();
				ani4time.schedule(new TimerTask() {

					public void run() {
						aniulti = 4;
					}			
				}, 400);
				
				Timer ani5time = new Timer();
				ani5time.schedule(new TimerTask() {

					public void run() {
						aniulti = 5;
					}			
				}, 500);
				
				Timer ani0time = new Timer();
				ani0time.schedule(new TimerTask() {

					public void run() {
						aniulti = 0;
					}				
				}, 600);
				
				Timer atime = new Timer();
				atime.schedule(new TimerTask() {

					public void run() {
						if(character == 0) {
							gp.enemies[0].life -= 4;
							gp.enemies[1].life -= 8;
							gp.enemies[2].life -= 4;
							gp.enemies[3].life -= 4;
						}
						if(character == 1) {
							gp.enemies[0].life -= 16;
							gp.enemies[1].life -= 16;
							gp.enemies[2].life -= 32;
							gp.enemies[3].life -= 16;
						}
						if(character == 2) {
							gp.enemies[0].life -= 16;
							gp.enemies[1].life -= 8;
							gp.enemies[2].life -= 8;
							gp.enemies[3].life -= 8;
						}
						
						if(gp.ui.commandNum == 0 || gp.ui.commandNum == 3) {
							if(gp.enemies[0].life < 1) {
								gp.gameState = gp.winState;
								if(character == 0) {
									gp.playSE(10);
								}
								if(character == 1) {
									gp.playSE(17);
								}
								if(character == 2) {
									gp.playSE(25);
								}
							}
						}

						if(gp.ui.commandNum == 1 || gp.ui.commandNum == 4) {
							if(gp.enemies[1].life < 1) {
								gp.gameState = gp.winState;
								if(character == 0) {
									gp.playSE(10);
								}
								if(character == 1) {
									gp.playSE(17);
								}
								if(character == 2) {
									gp.playSE(25);
								}
							}
						}

						if(gp.ui.commandNum == 2 || gp.ui.commandNum == 5) {
							if(gp.enemies[2].life < 1) {
								gp.gameState = gp.winState;
								if(character == 0) {
									gp.playSE(10);
								}
								if(character == 1) {
									gp.playSE(17);
								}
								if(character == 2) {
									gp.playSE(25);
								}
							}
						}
						
						if(gp.ui.commandNum == 6) {
							if(gp.enemies[3].life < 1) {
								gp.gameState = gp.winState;
								if(character == 0) {
									gp.playSE(10);
								}
								if(character == 1) {
									gp.playSE(17);
								}
								if(character == 2) {
									gp.playSE(25);
								}
							}
						}
					}			
				}, 500);
			}			
		}

		if(code == KeyEvent.VK_ESCAPE) {
						
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
				gp.playSE(28);
			}
			else if(gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
				gp.playSE(28);
			}
		}
		
		if(gp.gameState == gp.loseState) {
			gp.enemies[0].life = gp.enemies[0].maxLife;
			gp.enemies[1].life = gp.enemies[1].maxLife;
			gp.enemies[2].life = gp.enemies[2].maxLife;
			gp.enemies[3].life = gp.enemies[3].maxLife;
		}
		
		//Pause State
		if(gp.gameState == gp.pauseState || gp.gameState == gp.winState || gp.gameState == gp.loseState) {
		
			if(code == KeyEvent.VK_BACK_SPACE) {
				gp.playSE(27);
				gp.gameState = gp.screenState;
				gp.stopMusic();
				gp.playMusic(0);
				gp.player.life = gp.player.maxLife;
				gp.enemies[0].life = gp.enemies[0].maxLife;
				gp.enemies[1].life = gp.enemies[1].maxLife;
				gp.enemies[2].life = gp.enemies[2].maxLife;
				gp.enemies[3].life = gp.enemies[3].maxLife;
				gp.ui.commandNum = 0;
				turn = 0;
				character = 0;
			}
			
			if(code == KeyEvent.VK_ENTER) {
				System.exit(0);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
}
