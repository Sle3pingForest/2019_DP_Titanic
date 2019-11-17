import java.awt.desktop.SystemEventListener;
import java.util.Random;
import java.util.Scanner;

import modele.Modele;
import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.Human;
import modele.player.IA;
import modele.player.Player;

public class Main {

	public static void main(String[] args) {
		Plateau plateau = new Plateau("XVI");
		Plateau plateau2 = new Plateau("XVI");
		
		Player human = new Human(plateau,50,plateau.getListeBoat());
		Player IA = new IA(plateau2, 50, plateau.getListeBoat());
		
		//to remove this part when coding the view
		for(Boat b: plateau.getListeBoat()) {
			boolean isPlace = false;
			while(!isPlace) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Veuillez saisir la position X pour le bateau: " + b.getName());
				int x = sc.nextInt();
				System.out.println("Veuillez saisir la position Y pour le bateau: "  + b.getName());
				int y = sc.nextInt();
				System.out.println("Veuillez saisir la direction du bateau "  + b.getName() + ", 1 = horizontal | 0 = verticale :" );
				int direction = sc.nextInt();
				b.setHorizontal(direction == 1);
				isPlace = human.placeBoat(x,y,b);
			}		
			for(int i = 10 ; i >= 0 ; i--) {
				for(int j = 0; j < 11; j++) {
					System.out.print(human.getPlateau().getGrillPlayer()[j][i] + " | ");
				}
				System.out.println("\n");
			}

		}
		
		for(Boat b: plateau2.getListeBoat()) {
			boolean isPlace = false;
			while(!isPlace) {
				System.out.println("Patient IA place ses bateaux");
				Random rnd = new Random();
				int x =rnd.nextInt(11) ;
				int y = rnd.nextInt(11);
				int direction = rnd.nextInt(2);
				b.setHorizontal(direction == 1);
				isPlace = IA.placeBoat(x,y,b);
			}
		}

		Modele modele = new Modele(human,IA,plateau,plateau2);
		


		System.out.println("Plateau d'IA");
		
		for(int i = 10 ; i >= 0 ; i--) {
			for(int j = 0; j < 11; j++) {
				System.out.print(IA.getPlateau().getGrillPlayer()[j][i] + " | ");
			}
			System.out.println("\n");
		}
	}

}
