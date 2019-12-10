package modele.player.stategy;

import modele.gestionBoat.Case;
import modele.gestionBoat.Plateau;


public class StategyCroix extends Strategy {
        private int x ,y;
        private Plateau plateau;
        private Case[][] grillOpponent;
        private boolean shootOk;
         private String epoche;
	@Override
	public void shoot(Plateau p) {
		// TODO Auto-generated method stub
	plateau =p;
        shootOk= false;
        grillOpponent= this.plateau.getGrillOpponent();
        while(this.getshootOk()==false)
        {
            double x = Math.random();
            switch((int)x)
            {
                case 0: 
                      if(grillOpponent[this.getX()+1][this.getY()].isWater() || grillOpponent[this.getX()+1][this.getY()].getId()==-1) {
                     if(!grillOpponent[this.getX()+1][this.getY()].isTouched())
                     {
                        grillOpponent[this.getX()+1][this.getY()].touched();
                        grillOpponent[this.getX()+1][this.getY()].setWaterisTouched(true);
                         System.out.println("shooted on water!  x : "+getX()+" y :"+getY());
                         setShoot(true);
                     }
                    
                 //in case it's a boat
                 if(!grillOpponent[this.getX()+1][this.getY()].isWater() || grillOpponent[this.getX()+1][this.getY()].getId() != -1) {
                     if(!grillOpponent[this.getX()+1][this.getY()].isTouched()) //if it isn't touched yet
                     {   
                          this.epoche=getPlateau().getEpoch();
                          switch(this.epoche){
                           case "XVI" :
                               if( grillOpponent[this.getX()+1][this.getY()].getPv() == 1){
                                  grillOpponent[this.getX()+1][this.getY()].setPv(0);
                                   setShoot(true);
                                  //grillOpponent[this.getCordX()][this.getCordY()].touched();
                               }
                               else {
                                     grillOpponent[this.getX()+1][this.getY()].setPv(1);
                                    setShoot(true);
                               }
                              break;
                           case "XX" :
                               grillOpponent[this.getX()+1][this.getY()].setPv(0);
                              grillOpponent[this.getX()+1][this.getY()].touched();
                                 System.out.println("shooted a boat !  x : "+getX()+" y :"+getY());
                               setShoot(true);
                              break;
                           
                          } 
                     }
          
            }
                      }
                  case 1: 
                      if(grillOpponent[this.getX()][this.getY()-1].isWater() || grillOpponent[this.getX()][this.getY()-1].getId()==-1) {
                     if(!grillOpponent[this.getX()][this.getY()-1].isTouched())
                     {
                        grillOpponent[this.getX()][this.getY()-1].touched();
                        grillOpponent[this.getX()][this.getY()-1].setWaterisTouched(true);
                         System.out.println("shooted on water!  x : "+getX()+" y :"+getY());
                         setShoot(true);
                     }
                    
                 //in case it's a boat
                 if(!grillOpponent[this.getX()][this.getY()-1].isWater() || grillOpponent[this.getX()][this.getY()-1].getId() != -1) {
                     if(!grillOpponent[this.getX()][this.getY()-1].isTouched()) //if it isn't touched yet
                     {   
                          this.epoche=getPlateau().getEpoch();
                          switch(this.epoche){
                           case "XVI" :
                               if( grillOpponent[this.getX()][this.getY()-1].getPv() == 1){
                                  grillOpponent[this.getX()][this.getY()-1].setPv(0);
                                   setShoot(true);
                                  //grillOpponent[this.getCordX()][this.getCordY()].touched();
                               }
                               else {
                                     grillOpponent[this.getX()][this.getY()-1].setPv(1);
                                    setShoot(true);
                               }
                              break;
                           case "XX" :
                               grillOpponent[this.getX()][this.getY()-1].setPv(0);
                              grillOpponent[this.getX()][this.getY()-1].touched();
                                 System.out.println("shooted a boat !  x : "+getX()+" y :"+getY());
                               setShoot(true);
                              break;
                           
                          } 
                     }
          
            }
                      }    
            }
        }
	}
        
        
        public void setXY(int x , int y ){
           this.x = x ; 
           this.y =y;
        }
        
        public Plateau getPlateau()
        {
            return this.plateau;
        }
        public int getX(){
            return this.x;
        }
         public int getY(){
            return this.y;
        }
         private void setShoot(boolean b) {
        this.shootOk=b;
         }

    private boolean getshootOk() {
        return this.shootOk;
    
    }
}
