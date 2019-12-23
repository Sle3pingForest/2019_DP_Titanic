package modele.player.strategy;

import java.util.Random;
import modele.gestionBoat.Case;
import modele.gestionBoat.Plateau;

/**
 *
 * @author ileft
 */
public class StrategyCroix implements Strategy {

    private int x, y;
    private Plateau plateau;
    private Case[][] grillOpponent;
    private boolean shootOk;
    private String epoche;
    private boolean cont;
    private static int compt = 0;

    @Override
    public void shoot(Plateau p) {
        System.out.println("Strategy Croix");
        // TODO Auto-generated method stub
        this.cont = false;
        plateau = p;
        shootOk = false;
        grillOpponent = this.plateau.getGrillPlayer();

        System.out.println("avant !  x : " + getX() + " y :" + getY());
        while (this.getshootOk() == false) {
            /**
             * *****************************Water x
             * +1*****************************
             */
            if (this.plateau.getX() == -1) {
                System.out.println("first shoot croix ");
                Random rn = new Random();
                int h = rn.nextInt(10) + 1;
                int z = rn.nextInt(10) + 1;
                this.plateau.setXY(h, z);
                System.out.println(" 1:  !  x : " + getX() + " y :" + getY());
                System.out.println(" 1:  !  h : " + getX() + " z :" + getY());
                while (grillOpponent[this.getX() + 1][this.getY()].isDejaTireIci()
                        && grillOpponent[this.getX() + 1][this.getY()].isTouched()) {
                    h = rn.nextInt(10) + 1;
                    z = rn.nextInt(10) + 1;
                    this.plateau.setXY(h, z);
                }
                if (grillOpponent[h][z].getId() == -1) {
                    grillOpponent[h][z].setDejaTireIci(true);
                } else {
                    grillOpponent[h][z].isTouched();
                }
                System.out.println("2 :!  x : " + getX() + " y :" + getY());
                this.setShoot(true);

            } else {
                //this.setXY();

                Random rnd = new Random();
                int r = rnd.nextInt(4) + 1;
                System.out.println("r : " + r);
                switch (r) {
                    case 1:
                        if (this.getX() + 1 < 11
                                && !grillOpponent[this.getX() + 1][this.getY()].isDejaTireIci()
                                && grillOpponent[this.getX() + 1][this.getY()].getId() == -1) {

                            if (!grillOpponent[this.getX() + 1][this.getY()].isTouched()) {
                                System.out.println("I am here a water");
                                // grillOpponent[this.getX() + 1][this.getY()].touched();
                                grillOpponent[this.getX() + 1][this.getY()].setWaterisTouched(true);
                                grillOpponent[this.getX() + 1][this.getY()].setDejaTireIci(true);
                                /* if (compt < 3) {
                                this.plateau.setChange(true);
                                compt++;
                                this.plateau.setXY(this.getX(), this.getY());
                            } else {
                                this.plateau.setChange(false);
                                compt = 0;
                                this.plateau.setXY(this.getX() + 1, this.getY());
                            }*/
                                this.plateau.setXY(this.getX() + 1, this.getY());
                                System.out.println("shooted on water cas 1!  x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());

                                setShoot(true);

                            } //in case it's a boat
                            else if (grillOpponent[this.getX() + 1][this.getY()].getId() != -1) {
                                if (!grillOpponent[this.getX() + 1][this.getY()].isTouched()) //if it isn't touched yet
                                {
                                    System.out.println("I am here a boat");
                                    this.epoche = getPlateau().getEpoch();
                                    switch (this.epoche) {
                                        case "XVI":
                                            grillOpponent[this.getX() + 1][this.getY()].setPv(0);
                                            grillOpponent[this.getX() + 1][this.getY()].touched();

                                            this.plateau.setXY(this.getX() + 1, this.getY());
                                            System.out.println("shooted a boat cas 1 !  x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());
                                            this.plateau.setChange(true);
                                            setShoot(true);
                                            break;

                                        case "XX":

                                            if (grillOpponent[this.getX() + 1][this.getY()].getPv() == 1) {
                                                grillOpponent[this.getX() + 1][this.getY()].setPv(0);
                                                this.plateau.setXY(this.getX() + 1, this.getY());

                                                setShoot(true);
                                                this.plateau.setChange(true);
                                                grillOpponent[this.getX() + 1][this.getY()].touched();
                                            } else {
                                                grillOpponent[this.getX() + 1][this.getY()].setPv(1);
                                                this.plateau.setXY(this.getX() + 1, this.getY());
                                                this.plateau.setChange(true);
                                                setShoot(true);
                                            }
                                            break;
                                    }
                                }

                            }

                        }
                        break;
                    /**
                     * *****************************Water y -
                     * 1*****************************
                     */
                    case 2:
                        if (this.getY() - 1 > 0
                                && !grillOpponent[this.getX()][this.getY() - 1].isDejaTireIci()
                                && grillOpponent[this.getX()][this.getY() - 1].getId() == -1) {
                            if (!grillOpponent[this.getX()][this.getY() - 1].isTouched()) {
                                // grillOpponent[this.getX()][this.getY() - 1].touched();
                                grillOpponent[this.getX()][this.getY() - 1].setWaterisTouched(true);
                                grillOpponent[this.getX()][this.getY() - 1].setDejaTireIci(true);
                                /* if (compt < 5) {
                                this.plateau.setChange(true);
                                compt++;
                                this.plateau.setXY(this.getX(), this.getY());
                            } else {
                                this.plateau.setChange(false);
                                compt = 0;
                                this.plateau.setXY(this.getX(), this.getY() - 1);
                            }*/
                                System.out.println("shooted on water! cas 2  x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());
                                this.plateau.setXY(this.getX(), this.getY() - 1);
                                this.plateau.setChange(false);
                                setShoot(true);

                            } //in case it's a boat
                            else if (grillOpponent[this.getX()][this.getY() - 1].getId() != -1) {
                                if (!grillOpponent[this.getX()][this.getY() - 1].isTouched()) //if it isn't touched yet
                                {
                                    this.epoche = getPlateau().getEpoch();
                                    switch (this.epoche) {
                                        case "XVI":
                                            grillOpponent[this.getX()][this.getY() - 1].setPv(0);
                                            grillOpponent[this.getX()][this.getY() - 1].touched();

                                            this.plateau.setXY(this.getX(), this.getY() - 1);
                                            System.out.println("shooted a boat cas2 !  x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());
                                            setShoot(true);
                                            this.plateau.setChange(true);
                                            break;

                                        case "XX":

                                            if (grillOpponent[this.getX()][this.getY() - 1].getPv() == 1) {
                                                grillOpponent[this.getX()][this.getY() - 1].setPv(0);
                                                this.plateau.setXY(this.getX(), this.getY() - 1);
                                                setShoot(true);
                                                grillOpponent[this.getX()][this.getY() - 1].touched();
                                            } else {
                                                grillOpponent[this.getX()][this.getY() - 1].setPv(1);
                                                this.plateau.setXY(this.getX(), this.getY() - 1);
                                                this.plateau.setChange(true);
                                                setShoot(true);
                                            }
                                            break;

                                    }
                                }

                            }

                        }
                        break;
                    /**
                     * *****************************Water x
                     * -1*****************************
                     */
                    case 3:
                        if (this.getX() - 1 > 0
                                && !grillOpponent[this.getX() - 1][this.getY()].isDejaTireIci()
                                && grillOpponent[this.getX() - 1][this.getY()].getId() == -1) {
                            if (!grillOpponent[this.getX() - 1][this.getY()].isTouched()) {
                                // grillOpponent[this.getX()][this.getY() - 1].touched();
                                grillOpponent[this.getX() - 1][this.getY()].setWaterisTouched(true);
                                grillOpponent[this.getX() - 1][this.getY()].setDejaTireIci(true);

                                /*   if (compt < 3) {
                                this.plateau.setChange(true);
                                compt++;
                                this.plateau.setXY(this.getX(), this.getY());
                            } else {
                                this.plateau.setChange(false);
                                compt = 0;
                                this.plateau.setXY(this.getX() - 1, this.getY());
                            }*/
                                System.out.println("shooted on water! cas  3 x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());
                                this.plateau.setXY(this.getX() - 1, this.getY());
                                this.plateau.setChange(false);
                                setShoot(true);

                            } //in case it's a boat
                            else if (grillOpponent[this.getX() - 1][this.getY()].getId() != -1) {
                                if (!grillOpponent[this.getX() - 1][this.getY()].isTouched()) //if it isn't touched yet
                                {
                                    this.epoche = getPlateau().getEpoch();
                                    switch (this.epoche) {
                                        case "XVI":
                                            grillOpponent[this.getX() - 1][this.getY()].setPv(0);
                                            grillOpponent[this.getX() - 1][this.getY()].touched();

                                            this.plateau.setXY(this.getX() - 1, this.getY());
                                            System.out.println("shooted a boat cas3!  x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());
                                            setShoot(true);
                                            this.plateau.setChange(true);
                                            break;

                                        case "XX":

                                            if (grillOpponent[this.getX() - 1][this.getY()].getPv() == 1) {
                                                grillOpponent[this.getX() - 1][this.getY()].setPv(0);
                                                this.plateau.setXY(this.getX() - 1, this.getY());
                                                setShoot(true);
                                                grillOpponent[this.getX() - 1][this.getY()].touched();
                                            } else {
                                                grillOpponent[this.getX()][this.getY()].setPv(1);
                                                this.plateau.setXY(this.getX() - 1, this.getY());
                                                this.plateau.setChange(true);
                                                setShoot(true);
                                            }
                                            break;

                                    }
                                }

                            }
                            /**
                             * *****************************Water y
                             * +1*****************************
                             */
                        }
                        break;
                    case 4:
                        if (this.getY() + 1 < 11
                                && !grillOpponent[this.getX()][this.getY() + 1].isDejaTireIci()
                                && grillOpponent[this.getX()][this.getY() + 1].getId() == -1) {
                            if (!grillOpponent[this.getX()][this.getY() + 1].isTouched()) {
                                // grillOpponent[this.getX()][this.getY() - 1].touched();
                                grillOpponent[this.getX()][this.getY() + 1].setWaterisTouched(true);
                                grillOpponent[this.getX()][this.getY() + 1].setDejaTireIci(true);

                                /* if (compt < 4) {
                                this.plateau.setChange(true);
                                compt++;
                                this.plateau.setXY(this.getX(), this.getY());
                            } else {
                                this.plateau.setChange(false);
                                compt = 0;
                                this.plateau.setXY(this.getX(), this.getY() + 1);
                            }*/
                                System.out.println("shooted on water! cas  3 x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());
                                this.plateau.setXY(this.getX(), this.getY() + 1);
                                this.plateau.setChange(true);
                                setShoot(true);

                            } //in case it's a boat
                            else if (grillOpponent[this.getX()][this.getY() + 1].getId() != -1) {
                                if (!grillOpponent[this.getX()][this.getY() + 1].isTouched()) //if it isn't touched yet
                                {
                                    this.epoche = getPlateau().getEpoch();
                                    switch (this.epoche) {
                                        case "XVI":
                                            grillOpponent[this.getX()][this.getY() + 1].setPv(0);
                                            grillOpponent[this.getX()][this.getY() + 1].touched();

                                            this.plateau.setXY(this.getX(), this.getY() + 1);
                                            System.out.println("shooted a boat cas3!  x : " + getX() + " y :" + getY() + " id : " + this.grillOpponent[getX()][getY()].getId());
                                            setShoot(true);
                                            this.plateau.setChange(true);
                                            break;

                                        case "XX":

                                            if (grillOpponent[this.getX()][this.getY() + 1].getPv() == 1) {
                                                grillOpponent[this.getX()][this.getY() + 1].setPv(0);
                                                this.plateau.setXY(this.getX(), this.getY() + 1);
                                                setShoot(true);
                                                grillOpponent[this.getX()][this.getY() + 1].touched();
                                            } else {
                                                grillOpponent[this.getX()][this.getY() + 1].setPv(1);
                                                this.plateau.setXY(this.getX(), this.getY() + 1);
                                                this.plateau.setChange(true);
                                                setShoot(true);
                                            }
                                            break;

                                    }
                                }

                            }

                        }
                        break;
                    default:
                        System.out.println("I am here default nothing to do ");
                        break;
                }
            }
        }
    }

    public void setXY() {
        this.x = this.getX();
        this.y = this.getY();
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    public int getX() {
        return this.getPlateau().getX();
    }

    public int getY() {
        return this.getPlateau().getY();
    }

    private void setShoot(boolean b) {
        this.shootOk = b;
    }

    public void setCont(boolean cont) {
        this.cont = cont;
    }

    public boolean getCont() {
        return this.cont;
    }

    private boolean getshootOk() {
        return this.shootOk;

    }
}
