package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JLabel;

//import controller.ListenerShot;
import modele.player.Player;

public class CaseGraphic extends JButton{
	
	private int x, y;
	public Color color = Color.white;
	public boolean estTouche;
	public BufferedImage imageCase;
	public static int SIZE = 50;
	public boolean isWater;
	
	public CaseGraphic(int x,int y, String path){
		super("");
		this.x=x;
		this.y=y;
		this.estTouche = false;
		isWater = true;
		settingImage(path);
		setPreferredSize(new Dimension(SIZE, SIZE));
	}
	
	

	public void settingImage(String path) {
		try {
			imageCase = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Path error");
			e.printStackTrace();
		}
	}
	

	public boolean isEstTouche() {
		return estTouche;
	}



	public void setEstTouche(boolean estTouche) {
		this.estTouche = estTouche;
	}



	public BufferedImage getImageCase() {
		return imageCase;
	}



	public void setImageCase(BufferedImage imageCase) {
		this.imageCase = imageCase;
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isWater() {
		return isWater;
	}



	public void setWater(boolean isWater) {
		this.isWater = isWater;
	}



	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;

	}


}
