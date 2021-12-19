
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] jeu = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printjeu(jeu);
		
		while (true) {
			joueurTours(jeu, scanner);
			if (finPartie(jeu)){
				break;
			}
			printjeu(jeu);
			
			tourCPU(jeu);
			if (finPartie(jeu)){
				break;
			}
			printjeu(jeu);
		}
		scanner.close();
	}


	private static boolean finPartie(char[][] jeu) {
		
		if (quiGagne(jeu, 'X')) {	
			printjeu(jeu);
			System.out.println("Victoire Joueur");
			return true;
		}
		
		if (quiGagne(jeu, 'O')) {	
			printjeu(jeu);
			System.out.println("Victoire CPU ");
			return true;
		}
		
		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu[i].length; j++) {
				if (jeu[i][j] == ' ') {
					return false;
				}
			}
		}
		printjeu(jeu);
		System.out.println("Match nul !");
		return true;
	}


	private static boolean quiGagne(char[][] jeu, char symbole) {
		if ((jeu[0][0] == symbole && jeu [0][1] == symbole && jeu [0][2] == symbole) ||
			(jeu[1][0] == symbole && jeu [1][1] == symbole && jeu [1][2] == symbole) ||
			(jeu[2][0] == symbole && jeu [2][1] == symbole && jeu [2][2] == symbole) ||
			
			(jeu[0][0] == symbole && jeu [1][0] == symbole && jeu [2][0] == symbole) ||
			(jeu[0][1] == symbole && jeu [1][1] == symbole && jeu [2][1] == symbole) ||
			(jeu[0][2] == symbole && jeu [1][2] == symbole && jeu [2][2] == symbole) ||
			
			(jeu[0][0] == symbole && jeu [1][1] == symbole && jeu [2][2] == symbole) ||
			(jeu[0][2] == symbole && jeu [1][1] == symbole && jeu [2][0] == symbole) ) {
			return true;
		}
		return false;
	}


	private static void tourCPU(char[][] jeu) {
		Random rand = new Random();
		int ordreCPU;
		while (true) {
			ordreCPU = rand.nextInt(9) + 1;
			if (coupsValide(jeu, Integer.toString(ordreCPU))) {
				break;
			}
		}
		System.out.println("Mouvement du CPU " + ordreCPU);
		placeMove(jeu, Integer.toString(ordreCPU), 'O');
	}


	private static boolean coupsValide (char[][] jeu, String position) {
		switch(position) {
			case "1":
				return (jeu[0][0] == ' ');
			case "2":
				return (jeu[0][1] == ' ');
			case "3":
				return (jeu[0][2] == ' ');
			case "4":
				return (jeu[1][0] == ' ');
			case "5":
				return (jeu[1][1] == ' ');
			case "6":
				return (jeu[1][2] == ' ');
			case "7":
				return (jeu[2][0] == ' ');
			case "8":
				return (jeu[2][1] == ' ');
			case "9":
				return (jeu[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void joueurTours(char[][] jeu, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Choisir un chiffre correspondant a une case du jeu? (1-9)");
			userInput = scanner.nextLine();
			if (coupsValide(jeu, userInput)){
				break;
			} else {
				System.out.println(userInput + " est un mouvement impossible.");
			}
		}
		placeMove(jeu, userInput, 'X');
	}


	private static void placeMove(char[][] jeu, String position, char symbole) {
		switch(position) {
			case "1":
				jeu[0][0] = symbole;
				break;
			case "2":
				jeu[0][1] = symbole;
				break;
			case "3":
				jeu[0][2] = symbole;
				break;
			case "4":
				jeu[1][0] = symbole;
				break;
			case "5":
				jeu[1][1] = symbole;
				break;
			case "6":
				jeu[1][2] = symbole;
				break;
			case "7":
				jeu[2][0] = symbole;
				break;
			case "8":
				jeu[2][1] = symbole;
				break;
			case "9":
				jeu[2][2] = symbole;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	
	
	private static void printjeu(char[][] jeu) {
		System.out.println(jeu[0][0] + "|" +  jeu[0][1] + "|" +  jeu[0][2] );
		System.out.println("-+-+-");
		System.out.println(jeu[1][0] + "|" +  jeu[1][1] + "|" +  jeu[1][2] );
		System.out.println("-+-+-");
		System.out.println(jeu[2][0] + "|" +  jeu[2][1] + "|" +  jeu[2][2] );
	}
	
}