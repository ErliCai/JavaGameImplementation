package PongCOM;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle {
    double y,yVel;
	boolean upAccel,downAccel;
	int player, x;
	final double GRAVITY = 0.94;
	Ball a;
	
	public AIPaddle(int player, Ball b) {
		upAccel = false;
		downAccel = false;
		a = b;
		y = 210; yVel = 0;
		if(player == 1)
			x = 20;
		else
			x = 660;
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
	}

	public void move() {
		y = a.getY();
		if (y<0)
			y = 0;
		else if (y > 420)
			y = 420;
		
	}

	
	public int getY() {
		return (int) y;
	}

}
