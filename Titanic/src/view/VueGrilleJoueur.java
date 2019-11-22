package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controlleur.ControllerStartGame;
import controlleur.ControllerPoserBoat;
import modele.Modele;
import modele.gestionBoat.Plateau;
import modele.player.Player;

public class VueGrilleJoueur extends JPanel implements Observer {
	protected CaseGraphic[][] cases;
	protected CaseGraphic[] coordonneX, coordonneY;
	protected Player p;
	protected Modele modele;
	public Graphics g;
    protected JButton start;
	
	public VueGrilleJoueur(Modele modele) {
		this.p = modele.getP1();
		this.modele = modele;
    	this.setPreferredSize(new Dimension(CaseGraphic.SIZE*11, CaseGraphic.SIZE*11));
		initGrill();
        p.addObserver(this);
		this.addMouseListener(new ControllerPoserBoat(modele, this));

        this.start = new JButton("Start");
     	this.start.setEnabled(false);
     	this.start.addActionListener(new ControllerStartGame(modele, this));

     	
     	this.add(start,BorderLayout.EAST);
     	this.start.setPreferredSize(new Dimension(80,40));
	}
	
	public void initGrill() {
		this.cases = new CaseGraphic[Plateau.WIDTH-1][Plateau.HIGHT-1];
		this.coordonneX = new CaseGraphic[10];
		this.coordonneY = new CaseGraphic[10];
    	for(int i = 0; i < Plateau.HIGHT-1  ; i ++) {
			CaseGraphic cY = new CaseGraphic(0,(i+1)*CaseGraphic.SIZE,"images/para.jpg");
			this.coordonneY[i] = cY;
			CaseGraphic cX = new CaseGraphic((i+1)*CaseGraphic.SIZE, 0,"images/para.jpg");
			this.coordonneX[i] = cX;
    	}
		for(int i = 1 ; i < Plateau.WIDTH  ; i ++) {
			for(int j = 1; j < Plateau.HIGHT; j++) {
				CaseGraphic c1 = new CaseGraphic(i*CaseGraphic.SIZE, j*CaseGraphic.SIZE,"images/back.jpg");
				this.cases[i-1][j-1] = c1;
				//il faut envoyé les coordonnes au case de plateau.
			}
			

		}
	}
	 
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	this.g = g;
    	for (int j = 0; j < 10 ; j++ ) {
    		g.drawImage(coordonneY[j].getImageCase(),coordonneY[j].getX(), coordonneY[j].getY(),CaseGraphic.SIZE,CaseGraphic.SIZE,this);
    		g.drawImage(coordonneX[j].getImageCase(),coordonneX[j].getX(), coordonneX[j].getY(),CaseGraphic.SIZE,CaseGraphic.SIZE,this);
			g.setColor(Color.blue);
			g.drawRect(coordonneX[j].getX(), coordonneX[j].getY(),CaseGraphic.SIZE,CaseGraphic.SIZE);
			g.drawRect(coordonneY[j].getX(), coordonneY[j].getY(), CaseGraphic.SIZE,CaseGraphic.SIZE);
    	}
        for (int i = 0; i < 10 ; i++ )  {
        	for (int j = 0; j < 10 ; j++ ) {
        		g.drawImage(cases[i][j].getImageCase(),cases[i][j].getX(), cases[i][j].getY(),CaseGraphic.SIZE,CaseGraphic.SIZE,this);
    			g.setColor(Color.blue);
    			g.drawRect(cases[i][j].getX(), cases[i][j].getY(), CaseGraphic.SIZE,CaseGraphic.SIZE);
        	}
        }    
    	
        for (int i = 0; i < 10 ; i++ )  {
        	for (int j = 0; j < 10 ; j++ ) {
        		if(p.getPlateau().getGrillPlayer()[i+1][j+1].getid() != -1) {
        			try {
						BufferedImage image = ImageIO.read(getClass().getResourceAsStream("images/boat.png"));
			        	g.drawImage(image,cases[i][j].getX(), cases[i][j].getY(),CaseGraphic.SIZE,CaseGraphic.SIZE,this);
			        	
			        	g.setColor(Color.blue);
			        	g.drawRect(cases[i][j].getX(), cases[i][j].getY(), CaseGraphic.SIZE,CaseGraphic.SIZE);
			        		
					} catch (IOException e) {
						e.printStackTrace();
					}
        	    }
        	}
        } 
      
        
        
    }
    
   


	public CaseGraphic[][] getCases() {
		return cases;
	}

	public void setCases(CaseGraphic[][] cases) {
		this.cases = cases;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	        if(p.getReady()){
	        	this.start.setEnabled(true);
	        }
		repaint();
		
	}
    
}
