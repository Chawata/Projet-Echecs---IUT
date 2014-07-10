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
	private int[] obtenirCoordonnees()
	{
		Scanner scanner = new Scanner(System.in);
		boolean isLineValid = false, isColumnValid = false;
		String x = null, y = null;
		
		while (!isLineValid || !isColumnValid)
		{
			String temp = scanner.nextLine();
			// La chaîne ne doit faire que deux caractères, car l'entrée sera toujours de type "[A-H][1-8]".
			if (temp.length() == 2)
			{
				String input = temp.substring(0, 2);
				if (!isLineValid)
				{
					x = input.substring(0, 1);
					if (Echiquier.Ordonnees.contains(x))
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
					y = input.substring(1, 2);
					if (Echiquier.Abscisses.contains(y))
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
		
		int[] coordonnees = new int[2];
		coordonnees[0] = Echiquier.Ordonnees.indexOf(x);
		coordonnees[1] = Echiquier.Abscisses.indexOf(y);
		return coordonnees;
	}
	
	public Joueur()
	{
		this.nom = null;
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
		int[] coordonneesDepart = this.obtenirCoordonnees();
		return new Case(coordonneesDepart[0], coordonneesDepart[1]);
	}

	/**
	 * Retourne une Case qui correspond à la case sur laquelle on veut déplacer une pièce.
	 * @return Case valide
	 */
	public Case saisirCaseArrivee()
	{
		System.out.println("Saisissez la case sur laquelle vous souhaitez déplacer votre pièce (ligne puis colonne) : ");
		int[] coordonneesArrivee = this.obtenirCoordonnees();
		return new Case(coordonneesArrivee[0], coordonneesArrivee[1]);
	}

	public String toString()
	{
		return this.getNom();	
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		
		if (!(o instanceof Joueur))
		{
			return false;
		}
		
		Joueur j = (Joueur)o;
		return this.getNom().equals(j.getNom());
	}
	
	public void initialiserJoueur()
	{
		Scanner sc = new Scanner(System.in);
	
		System.out.println("\tEntrez votre nom : ");
		String name = sc.nextLine();
		this.nom = new String(name);
	}

	public String getNom()
	{
		return this.nom;
	}
}
