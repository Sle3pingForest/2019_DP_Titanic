package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controlleur.ControllerPoserBoat;
import controlleur.ControllerTirer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modele.Modele;
import modele.gestionBoat.Plateau;
import modele.player.Player;

public class VueGrilleEnnemi extends JPanel   implements Observer, MouseListener{
	protected CaseGraphic[][] cases;
	protected CaseGraphic[] coordonneX, coordonneY;
	protected Modele modele;
	protected Player p;
        private boolean myturn;
	
	public VueGrilleEnnemi(Modele modele) {
                myturn =true;
		this.modele = modele;
		this.p = modele.getP1();
    	this.setPreferredSize(new Dimension(CaseGraphic.SIZE*11, CaseGraphic.SIZE*11));
		initGrill();
        p.addObserver(this);
       
            this.addMouseListener(this);
		
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
        
        /*for (int i = 0; i < 10 ; i++ )  {
        	for (int j = 0; j < 10 ; j++ ) {
        		if(p.getPlateau().getGrillOpponent()[i+1][j+1].getid() != -1) {
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
        } */ //function a decommente si vous voulez voir le bateau d'ennemie
        
        for (int i = 0; i < 10 ; i++ )  {
        	for (int j = 0; j < 10 ; j++ ) {
        		if(p.getPlateau().getGrillOpponent()[i+1][j+1].isTouched()) {
        			try {
				       BufferedImage image = ImageIO.read(getClass().getResourceAsStream("images/Checkp.png"));
			        	g.drawImage(image,cases[i][j].getX(), cases[i][j].getY(),CaseGraphic.SIZE,CaseGraphic.SIZE,this);
			        	
			        	g.setColor(Color.blue);
			        	g.drawRect(cases[i][j].getX(), cases[i][j].getY(), CaseGraphic.SIZE,CaseGraphic.SIZE);
			        	this.setMyturn(false);
					} catch (IOException e) {
						e.printStackTrace();
					}
        	    }
        		else if(p.getPlateau().getGrillOpponent()[i+1][j+1].isDejaTireIci()) {
        			try {
						BufferedImage image = ImageIO.read(getClass().getResourceAsStream("images/touche.png"));
			        	g.drawImage(image,cases[i][j].getX(), cases[i][j].getY(),CaseGraphic.SIZE,CaseGraphic.SIZE,this);
			        	
			        	g.setColor(Color.blue);
			        	g.drawRect(cases[i][j].getX(), cases[i][j].getY(), CaseGraphic.SIZE,CaseGraphic.SIZE);
			        	this.setMyturn(false);	
					} catch (IOException e) {
						e.printStackTrace();
					}
        		}
                      
        		
        	
        } 
           // System.out.println("affichage !!!!!!");
       // this.myturn=false;
        } 
    
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

		repaint();
	}

    public boolean isMyTurn() {
        return this.myturn;
    }

    public void setMyturn(boolean b) {
     this.myturn=b;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(p.getReady()){
        //if(this.isMyTurn()){
      	int x = e.getX()/CaseGraphic.SIZE;
		int y = e.getY()/CaseGraphic.SIZE;
		if(this.modele.tire(x, y)) {
               
			System.out.println("touche trop fort");
		}
		else {
                       //  this.vue.setMytruen(false);
			System.out.println("loupe gros noob");
		}
        
             
                 this.modele.getP2().shoot(modele.getP1().getPlateau());
                 this.myturn=true;
               //  this.setMyturn(true);
       // }
        } 
        
         
               
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

