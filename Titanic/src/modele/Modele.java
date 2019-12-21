package modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.options.Options;
import modele.player.Human;
import modele.player.IA;
import modele.player.Player;

public class Modele extends Observable {
	
	public Player p1;
	public Player p2;
	public Plateau plateau;
	public Plateau plateau2;
	private State state;
	private String epoque;
	public static String[] DIRECTION = {"EAST", "SOUTH", "WEST", "NORTH"};
	
	public Modele(Options options) {
		super();
		this.epoque = options.getEpoque();
		Plateau plateau = new Plateau(epoque);
		Plateau plateau2 = new Plateau(epoque);
		this.p1 = new Human(plateau,50,plateau.getListeBoat());
		this.p2 = new IA(plateau2, 50, plateau.getListeBoat(), options.getStrategy());

		init(plateau, plateau2);

	}

	private void init(Plateau plateau, Plateau plateau2) {
		this.plateau = plateau;
		this.plateau2 = plateau2;
		this.p1.setPlateau(plateau); //Player
		this.p2.setPlateau(plateau2); //IA
		this.state = State.SELECTCASETOPLACE;
		plateau.setGrillOpponent(plateau2.getGrillPlayer());
		plateau2.setGrillOpponent(plateau.getGrillPlayer());
		settingBoatPositionP2();
	}

	public ArrayList<Integer> checkPosition(int x , int y , int idBoat) {
		return p1.validePosition(x, y, idBoat);
	}
	
	public boolean settingBoatPositionP1(int x, int y, String direction, int idBoat) {
			boolean isOk = false;
			if (direction == null)
				return  false;
			if(direction.compareTo(DIRECTION[0]) == 0) {
				isOk = p1.placeBoat(x,y,0 ,idBoat);
			}
			if(direction.compareTo(DIRECTION[1]) == 0) {
				isOk = p1.placeBoat(x,y,1 ,idBoat);
			}
			if(direction.compareTo(DIRECTION[2]) == 0) {
				isOk = p1.placeBoat(x,y,2 ,idBoat);
			}
			if(direction.compareTo(DIRECTION[3]) == 0) {
				isOk = p1.placeBoat(x,y,3 ,idBoat);
			}
			update();
			return isOk ;	
	}
	
	
	
	public void settingBoatPositionP2() {//Randome setting because P2 is a IA
		ArrayList<Integer> directions = new ArrayList<Integer>();
		for(Boat b: p2.getBoats()) {
			boolean isPlace = false;
			while(!isPlace) {
				Random rnd = new Random();
				int x =rnd.nextInt(11);
				int y = rnd.nextInt(11);
				directions = p2.validePosition(x, y, b.getId());
				if(directions.size() != 0 && x != 0 && y != 0) {
					int index = 0 + rnd.nextInt(directions.size());
					isPlace = p2.placeBoat(x,y,directions.get(index),b.getId());
				}
			}
			update();
		}
	}
	
	public void tire(int x, int y) {
		if (!p2.getPlateau().getGrillPlayer()[x][y].isDejaTireIci()){
			if(p1.tireTouched(x, y)) {
				p2.getPlateau().getGrillPlayer()[x][y].setTouched(true);
				p2.getPlateau().getGrillPlayer()[x][y].setDejaTireIci(true);
			}
			else {
				p2.getPlateau().getGrillPlayer()[x][y].setDejaTireIci(true);
			}
			p2.shoot(p1.getPlateau());
			update();
		}
	}

	private void update(){
		setChanged();
		notifyObservers();
	}

	public void newGame(){
		Plateau pp1 = new Plateau(epoque);
		Plateau pp2 = new Plateau(epoque);
		init(pp1, pp2);
		update();
	}

	public Player getP1() {
		return p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public void setState(State state){
		this.state = state;
		update();
	}

	public State getState(){
		return state;
	}
       public Plateau getPlateau()
       {
           return this.plateau;
       }
		public Plateau getPlateau1()
       {
           return this.plateau2;
       }

	public void setStrategy(String strategy) {
		IA player = (IA)p2;
		player.setStrategy(strategy);
	}
}
