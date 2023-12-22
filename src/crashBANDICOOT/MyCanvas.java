package crashBANDICOOT;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MyCanvas extends Canvas implements KeyListener {
	goodguy link = new goodguy(10, 10, 60, 60, "files/bandicoot.jpg");
	LinkedList<badguy> badguys = new LinkedList();
	LinkedList<projectile> masks = new LinkedList();
	int kills = 0;
	int level = 1;
	String rank = "newbie";

	public MyCanvas() {
		this.setSize(800, 600);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);
		this.respawn();
		TimerTask repeatedTask = new TimerTask() {
		    @Override
		    public void run() {
		        // Add the code that should be executed periodically

		        // Example: Update game logic, respawn bad guys, repaint canvas
		        repaint();
		    }
		};
		Timer timer = new Timer("Timer");
		long delay = 1000L;
		long period = 1000L;
		timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}

	public void respawn() {
		Random rand = new Random();
		int winwidth = this.getWidth();
		int winheight = this.getHeight();

		for (int i = 0; i < 10; ++i) {
			badguy bg = new badguy(rand.nextInt(winwidth), rand.nextInt(winheight), 120, 50, "files/badguyright.png");
			new Rectangle(100, 100, 30, 30);
			this.badguys.add(bg);
		}

	}

	public void paint(Graphics g) {
		g.drawImage(this.link.getImg(), this.link.getxCoord(), this.link.getyCoord(), this.link.getWidth(),
				this.link.getHeight(), this);
		System.out.println(this.badguys.size());
		if (this.badguys.size() == 0) {
			++this.level;
			this.respawn();
			if (this.level == 2) {
				this.rank = "beginner";
			}

			if (this.level == 4) {
				this.rank = "apprentice";
			}

			if (this.level == 6) {
				this.rank = "junior master";
			}

			if (this.level == 8) {
				this.rank = "master";
			}

			if (this.level == 10) {
				this.rank = "senior master";
			}

			if (this.level == 12) {
				this.rank = "el maestro";
			}

			if (this.level == 14) {
				this.rank = "el maestro supremo";
			}

			if (this.level == 20) {
				this.rank = "Mr Hoel";
			}
		}

		for (int i = 0; i < this.badguys.size(); ++i) {
			badguy bg = (badguy) this.badguys.get(i);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());

			for (int j = 0; j < this.masks.size(); ++j) {
				projectile k = (projectile) this.masks.get(j);
				if (k.getxCoord() > (float) this.getWidth()) {
					this.masks.remove(k);
				}

				System.out.println(this.link.imgname);
				if (this.link.imgname.equals("files/bandicoot.jpg")) {
					k.setxCoord((float) ((double) k.getxCoord() + 0.3));
				} else {
					k.setxCoord((float) ((double) k.getxCoord() - 0.3));
				}

				g.drawImage(k.getImg(), (int) k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
				Rectangle kr = new Rectangle((int) k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());
				if (kr.intersects(r)) {
					++this.kills;
					this.badguys.remove(i);
					this.masks.remove(j);
				}

				this.repaint();
			}
		}

		g.setFont(new Font("TimesRoman", 0, 20));
		g.drawString("Kills: " + String.valueOf(this.kills).toString(), 20, 25);
		g.drawString("Level: " + String.valueOf(this.level).toString(), 20, 45);
		g.drawString("Rank: " + this.rank, 20, 65);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 32) {
			projectile mask = new projectile(this.link.getxCoord(), this.link.getyCoord(), 20, 20,
					"files/Boomerang.png");
			this.masks.add(mask);
		}

		System.out.println(e);
		this.link.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());

		for (int i = 0; i < this.badguys.size(); ++i) {
			badguy bg = (badguy) this.badguys.get(i);
			Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
			Rectangle gg = new Rectangle(this.link.getxCoord(), this.link.getyCoord(), this.link.getWidth(),
					this.link.getHeight());
			if (r.intersects(gg)) {
				System.out.println("badguy hit by Crash");
				this.badguys.remove(i);
				++this.kills;
			}
		}

		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
	}
}
