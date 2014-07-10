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
