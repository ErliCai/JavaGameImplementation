package PongCOM;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Tennis extends Applet implements Runnable, KeyListener {
	Thread thread;
	
	final int WIDTH = 700,  HEIGHT = 500;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	
	
	public void init() {
		this.resize(WIDTH,HEIGHT);
		
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		p2 = new AIPaddle(2,b1);
		b1 = new Ball();
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getX() < -10 || b1.getX() > 710) {
			g.setColor(Color.red);
			g.drawString("Game Over!!", 300 , 250);
		}
		p1.draw(g);
		p2.draw(g);
		b1.draw(g);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {
		for(;;) {
			
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() ==  KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if (e.getKeyCode() ==  KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() ==  KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		else if (e.getKeyCode() ==  KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
		
  
	}

}
