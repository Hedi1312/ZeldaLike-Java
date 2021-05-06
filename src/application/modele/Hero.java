package application.modele;

import java.util.Scanner;

public class Hero {
	
	public Hero() {
		
	}
	
	public static char deplacement() {
		
		Scanner saisie = new Scanner(System.in);
		String choix=(saisie.next());
		char c = choix.charAt(0);
		switch (c) {
			case 'z':
				System.out.println("Joueur va vers le haut");
				break;
			case 'q':
				System.out.println("Joueur va vers la gauche");
				break;
			case 's':
				
				System.out.println("Joueur va vers le bas");
				break;
			case 'd':
				System.out.println("Joueur va vers la droite");
				break;
			default:
				System.out.println("Pas autant de choix");
		}
	
	while(c!=4);
	return c;
	}
}
