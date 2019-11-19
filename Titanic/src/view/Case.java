package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

//import controller.ListenerShot;
import modele.player.Player;

public class Case extends JButton{
	
	public static int size = 50;
	public Color color = Color.white;
	private int x, y;
	
	
	public Case(int x,int y){
		super("");
		this.x=x;
		this.y=y;
		setPreferredSize(new Dimension(size, size));
		add(new JLabel(String.valueOf(x/50)));
	}

	
	public Case(int x,int y, Player p){
		super("");
		//addMouseListener(new ListenerShot(p));
		this.x=x;
		this.y=y;
		setPreferredSize(new Dimension(size, size));
	}

	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setColor(Color color) {
		this.color = color;

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}


}
