package modele.gestionBoat;

import java.util.ArrayList;
import java.util.Collection;

public class Plateau {

    public static final int HIGHT = 11;
    public static final int WIDTH = 11;
    public static final String XVI = "XVI";
    public static final String XX = "XX";
    private String epoch;
    private int idBoat;
    protected Case[][] grillOpponent;
    protected Case[][] grillPlayer;
    protected ArrayList<Boat> listeBoatPlayer;
    private int x;
    private int y;
    private boolean change;

    public Plateau(String epoch) {
        idBoat = 0;
        x = -1;
        y = -1;
        this.change = false; //strat random
        this.grillPlayer = new Case[WIDTH][HIGHT];
        this.grillOpponent = new Case[WIDTH][HIGHT];
        this.epoch = epoch;
        this.listeBoatPlayer = new ArrayList<Boat>();
        initializerPlateau();
        settingBoat();

    }

    public Plateau(Case[][] player, Case[][] opponent, String epoque, ArrayList<Boat> boat) {
        this.grillPlayer = player;
        this.grillOpponent = opponent;
        this.epoch = epoque;
        this.listeBoatPlayer = boat;
    }

    //check if can place the boat with no collison on other , and the boat stay on plateau on out range
    public ArrayList<Integer> boatPositionEmpty(Case[][] grille, int x, int y, int idboat) {
        ArrayList<Integer> listeDirection = new ArrayList<Integer>();
        boolean empty = true;
        if (idboat > 4) {
            return listeDirection;

        }
        if (isEmpty(grille, x, y) && (x + listeBoatPlayer.get(idboat).getSize() <= WIDTH)) {
            int i = 0;
            while (i < listeBoatPlayer.get(idboat).getSize() && empty) {
                empty = isEmpty(grille, x + i, y);
                i++;
            }
            if (empty) {
                listeDirection.add(0);
            }
        }
        empty = true;
        if (isEmpty(grille, x, y) && (y + listeBoatPlayer.get(idboat).getSize() <= HIGHT)) {
            int i = 0;
            while (i < listeBoatPlayer.get(idboat).getSize() && empty) {
                empty = isEmpty(grille, x, y + i);
                i++;
            }
            if (empty) {
                listeDirection.add(1);
            }
        }
        empty = true;
        if (isEmpty(grille, x, y) && (x - listeBoatPlayer.get(idboat).getSize() >= 0)) {
            int i = 0;
            while (i < listeBoatPlayer.get(idboat).getSize() && empty) {
                empty = isEmpty(grille, x - i, y);
                i++;
            }
            if (empty) {
                listeDirection.add(2);
            }
        }
        empty = true;
        if (isEmpty(grille, x, y) && (y - listeBoatPlayer.get(idboat).getSize() >= 0)) {
            empty = true;
            int i = 0;
            while (i < listeBoatPlayer.get(idboat).getSize() && empty) {
                empty = isEmpty(grille, x, y - i);
                i++;
            }
            if (empty) {
                listeDirection.add(3);
            }
        }
        return listeDirection;
    }

    public boolean strike(int x, int y) {
        if (grillOpponent[x][y].getId() != -1) {
            grillOpponent[x][y].setTouched(true);
        } else {
            grillOpponent[x][y].setDejaTireIci(true);
        }
        return grillOpponent[x][y].getId() != -1;
    }

    public String getEpoch() {
        return epoch;
    }

    public Case[][] getGrillOpponent() {
        return grillOpponent;
    }

    public Case[][] getGrillPlayer() {
        return grillPlayer;
    }

    //getter and setter
    public ArrayList<Boat> getListeBoat() {
        return listeBoatPlayer;
    }

    public void initializerPlateau() {
        int i, j;
        for (i = 0; i < WIDTH; i++) {
            for (j = 0; j < HIGHT; j++) {
                grillPlayer[i][j] = new Case(-1, i, j);//Empty
                grillOpponent[i][j] = new Case(-1, i, j);
            }
        }

    }

    public boolean isEmpty(Case[][] grille, int x, int y) {
        if (grille[x][y].isWater() && grille[x][y].getid() == -1) {
            return true;//true if is Empty
        }
        return false;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public void setGrilleValue(int i, int j, int val) {
        this.grillPlayer[i][j].setId(val);
    }

    public void setGrillOpponent(Case[][] grillOpponent) {
        this.grillOpponent = grillOpponent;
    }

    public void setGrillPlayer(Case[][] grillPlayer) {
        this.grillPlayer = grillPlayer;
    }

    public void setListeBoat(ArrayList<Boat> listeBoat) {
        this.listeBoatPlayer = listeBoat;
    }

    public void setListeBoat2(ArrayList<Boat> listeBoat) {
        this.listeBoatPlayer = listeBoat;
    }

    //function who bluid 5 boat at position 0 0
    public void settingBoat() {
        Boat portAvion, croiseur, sousMarins, sousMarins2, torpilleur;
        if (epoch.compareTo(XVI) == 0) {
            portAvion = new BoatXVI("Porte Avion", 0, 0, 0, 5, -1);
            croiseur = new BoatXVI("Croiseur", 1, 0, 0, 4, -1);
            sousMarins2 = new BoatXVI("Sous Marins 2", 2, 0, 0, 3, -1);
            sousMarins = new BoatXVI("Sous Marins", 3, 0, 0, 3, -1);
            torpilleur = new BoatXVI("Torpilleur", 4, 0, 0, 2, -1);
        } else {
            portAvion = new BoatXX("Porte Avion", 0, 0, 0, 5, -1);
            croiseur = new BoatXX("Croiseur", 1, 0, 0, 4, -1);
            sousMarins2 = new BoatXX("Sous Marins 2", 2, 0, 0, 3, -1);
            sousMarins = new BoatXX("Sous Marins", 3, 0, 0, 3, -1);
            torpilleur = new BoatXX("Torpilleur", 4, 0, 0, 2, -1);
        }

        this.listeBoatPlayer.add(portAvion);
        this.listeBoatPlayer.add(croiseur);
        this.listeBoatPlayer.add(sousMarins);
        this.listeBoatPlayer.add(sousMarins2);
        this.listeBoatPlayer.add(torpilleur);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        StringBuilder op = new StringBuilder("");
        sb.append("Epoque : " + epoch);
        sb.append("\nPlayer's grid : \n");
        for (int i = 0; i < WIDTH; i++) {
            sb.append("[");
            op.append("[");
            for (int j = 0; j < HIGHT; j++) {
                sb.append("[").append(grillPlayer[i][j]).append("] ");
                op.append("[").append(grillOpponent[i][j]).append("] ");
            }
            sb.append("]\n");
            op.append("]\n");
        }
        sb.append("\n Enemy's grid : \n");
        sb.append(op.toString());
        return sb.toString();
    }

    public void resetIdBoat() {
        idBoat = 0;
    }

    public int getIdBoat() {
        return idBoat;
    }

    public void increaseIdBoat(int x) {
        idBoat = idBoat + x;
    }

    public void setIdBoat(int idBoat) {
        this.idBoat = idBoat;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setChange(boolean b) {
        this.change = b;
    }

    public boolean getChange() {
        return this.change;   //change true : strategy croix 
    }
}
