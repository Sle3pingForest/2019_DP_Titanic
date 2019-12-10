package modele.player.stategy;

import java.util.Random;
import modele.gestionBoat.Plateau;
import modele.gestionBoat.*;

public class StategyRandom extends Strategy {
    private Plateau plateau;
     private String epoche;
     private static int DEGAT ;
     public int x , y;
     private int cordX,cordY;//cord shoot
     private boolean shootOk ;
     private Case[][] grillOpponent;
     
	@Override
	public void shoot(Plateau p) {
             this.shootOk =false;
             this.plateau =p;
             grillOpponent= this.plateau.getGrillPlayer();
             //getDamage();
            setCordXY();
             while(getshootOk() == false ){
                //in case if it's a  waater 
                if(grillOpponent[this.getCordX()][this.getCordY()].isWater() || grillOpponent[this.getCordX()][this.getCordY()].getId()==-1) {
                     if(!grillOpponent[this.getCordX()][this.getCordY()].isTouched())
                     {
                         
                         grillOpponent[this.getCordX()][this.getCordY()].setWaterisTouched(true);
                         grillOpponent[this.getCordX()][this.getCordY()].setDejaTireIci(true);
                         setShoot(true);
                         
                     }
                     else 
                        setCordXY();
                       
                 }
                 //in case it's a boat
                 if(!grillOpponent[this.getCordX()][this.getCordY()].isWater() || grillOpponent[this.getCordX()][this.getCordY()].getId() != -1) {
                     if(!grillOpponent[this.getCordX()][this.getCordY()].isTouched()) //if it isn't touched yet
                     {   
                          this.epoche=plateau.getEpoch();
                          switch(this.epoche){
                           case "XVI" :
                               if( grillOpponent[this.getCordX()][this.getCordY()].getPv() == 1){
                                  grillOpponent[this.getCordX()][this.getCordY()].setPv(0);
                                  setShoot(true);
                               }
                               else {
                                   grillOpponent[this.getCordX()][this.getCordY()].setPv(1);
                                   setShoot(true);
                               }
                               grillOpponent[this.getCordX()][this.getCordY()].touched();
                              break;
                           case "XX" :
                              grillOpponent[this.getCordX()][this.getCordY()].setPv(0);
                              grillOpponent[this.getCordX()][this.getCordY()].touched();
                               setShoot(true);
                              break;
                           
                          } 
                     }
                     else {
                         setCordXY();
                     }
                     
                 }
                 else 
                     setCordXY();    
             }
	}
        
          /**********manage damage**********/
      /*  private int getDamage(){
           
             this.epoche=plateau.getEpoch();
             switch(this.epoche){
                 case "XVI" :
                     this.DEGAT = 1;break;
                 case "XX" :
                     this.DEGAT = 2;break;
                 default:
                    this.DEGAT = 1; break;
                 
             } 
             return this.DEGAT;
        }*/
        /**********end manage damage**********/
        
        
        /************Setter -Getter***********/
        public void setXY(){
            this.x=this.plateau.HIGHT;
            this.y=this.plateau.WIDTH;
        }
        
        
        public void setCordXY(){
            Random rnd = new Random();
	    cordX =rnd.nextInt(10) + 1 ;
            cordY = rnd.nextInt(10) + 1;
        }
        
        public int getCordX(){
            //System.out.print("cord X "+cordX);
                return this.cordX;
        }
        public int getCordY(){
             // System.out.print("cord Y "+cordY);
                return this.cordY;
        }

    private void setShoot(boolean b) {
        this.shootOk=b;
    }

    private boolean getshootOk() {
        return this.shootOk;
    
    }
        
        /**************End setter getter********************/
}
