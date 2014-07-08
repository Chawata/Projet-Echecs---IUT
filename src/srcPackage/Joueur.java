/*** @version 1.0 
* @Husch Julien*/

package srcPackage;

import java.util.Scanner;

public class Joueur
{
	private String nom;
	
	/**
	 * Méthode qui demande et retourne les coordonnées (x ; y) et qui vérifie qu'elles sont valides.
	 * @return Un tableau de 2 int, respecivement x et y.
	 */
	private int[] obtenirCooredonnees()
	{
		Scanner scanner = new Scanner(System.in);
		boolean isLineValid = false, isColumnValid = false;
		String x = null, y = null;
		
		while (!isLineValid && !isColumnValid)
		{
			String input = scanner.nextLine();
			// La chaîne ne doit faire que deux caractères, car l'entrée sera toujours de type "[A-H][1-8]".
			if (input.length() == 2)
			{
				if (!isLineValid)
				{
					x = scanner.nextLine();
					if (Echiquier.Abscisses.contains(x))
					{
						isLineValid = true;
					}
					else
					{
						System.out.println("La ligne demand�e est invalide, merci de recommencer.");
					}
				}
				
				if (!isColumnValid)
				{
					y = scanner.nextLine();
					if (Echiquier.Ordonnees.contains(y))
					{
						isColumnValid = true;
					}
					else
					{
						System.out.println("La colonne demand�e est invalide, merci de recommencer.");
					}
				}
			}
			else
			{
				System.out.println("Entr�e incorrecte, merci de recommencer.");
			}
		}
		
		scanner.close();
		
		int[] coordonnees = new int[2];
		coordonnees[0] = Echiquier.Abscisses.indexOf(x);
		coordonnees[1] = Echiquier.Abscisses.indexOf(x);
		
		return coordonnees;
	}
	
	public Joueur(String nomJoueur)
	{
		this.nom = nomJoueur;
	}
	
	/**
	 * Retourne une Case qui correspond à la case sur laquelle se trouve la pièce à déplacer.
	 * @return Case valide
	 */
	public Case saisirCaseDepart()
	{
		System.out.println("Saisissez la case sur laquelle se trouve la pièce que vous souhaitez déplacer (ligne puis colonne) : ");
		int[] coordonneesDepart = this.obtenirCooredonnees();
		return new Case(coordonneesDepart[0], coordonneesDepart[1]);
	}

	/**
	 * Retourne une Case qui correspond à la case sur laquelle on veut déplacer une pièce.
	 * @return Case valide
	 */
	public Case saisirCaseArrivee()
	{
		System.out.println("Saisissez la case sur laquelle vous souhaitez déplacer votre pièce (ligne puis colonne) : ");
		int[] coordonneesArrivee = this.obtenirCooredonnees();
		return new Case(coordonneesArrivee[0], coordonneesArrivee[1]);
	}

	public String toString()
	{
		return this.getNom();	
	}

	public String getNom()
	{
		return this.nom;
	}
}
