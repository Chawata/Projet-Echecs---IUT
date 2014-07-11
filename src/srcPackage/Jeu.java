/**
 * Classe principale qui se contente d'afficher le menu et de lancer une partie.
 * @author Ben Vittupier
 */

/*
 * TODO : menu + charger partie
 */

package srcPackage;

public class Jeu
{
	public static void main(String[] args)
	{
		System.out.println("Bienvenue dans Echecs-IUT !\n");
		Partie p = new Partie();
		p.init();
		p.jouer();
	}
}
