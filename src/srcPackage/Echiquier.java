/**
* Classe représentant un Échiquier et tout ce qui lui correspond.
* @version 1.0 
* @author Anne-Sophie Segonds
*/

package srcPackage;

import java.util.List;
import java.util.Arrays;

public class Echiquier
{
	public static final List<String> Abscisses = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
	public static final List<String> Ordonnees = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
	private static final int N = 8;
	
	private Case[][] tabCase; 
	
	/**
	 * Créé un échiquer de 8 par 8 et l'initialise avec des cases vides.
	 */
	public Echiquier()
	{
		this.tabCase = new Case[N][N];

		for(int i = 0; i < this.tabCase.length; i++)
		{
			for(int j = 0; j < this.tabCase[i].length; j++)
			{
				this.tabCase[i][j] = new Case(i, j);
			}
		}
	}

	public String toString()
	{
		String result = " ";
		
		for(int i = 0; i < Echiquier.Abscisses.size(); i++)
		{
			result = result + "  "  + Echiquier.Abscisses.get(i); 
		}
		result = result + "\n";
		
		for(int i = 0; i < this.tabCase.length; i++)
		{
			result = result + Echiquier.Ordonnees.get(i) + " "; 
	
			for(int j = 0; j < this.tabCase[i].length; j++)
			{		
				result = result + " " + this.tabCase[i][j]  + " ";
			}
			result = result + "\n" ;
		}
	
		return result;	
	}

	public Case getCase(int i, int j)
	{
		return this.tabCase[i][j];
	}

	/**
	 * Méthode qui, pour un échiquier créé, va initialiser les cases avec les pièces par défaut.
	 */
	public void initialiserEchiquier()
	{
		final int ligneNoirPion = 1;
	 	final int ligneBlanchePion = 6;
	 	final int ligneNoir = 0;
	 	final int ligneBlanche = 7;
	 	
	 	
	 	for(int i = 0; i < Echiquier.Abscisses.size(); i++)
	 	{
	 		this.tabCase[ligneNoirPion][i].setPiece(new Pion(EnumCouleurs.NOIR));
	 		this.tabCase[ligneBlanchePion][i].setPiece(new Pion(EnumCouleurs.BLANC)); 
	 	}
	 	
	 	this.tabCase[ligneNoir][0].setPiece(new Tour(EnumCouleurs.NOIR));
	 	this.tabCase[ligneNoir][1].setPiece(new Cavalier(EnumCouleurs.NOIR));
	 	this.tabCase[ligneNoir][2].setPiece(new Fou(EnumCouleurs.NOIR));
	 	this.tabCase[ligneNoir][3].setPiece(new Roi(EnumCouleurs.NOIR));
	 	this.tabCase[ligneNoir][4].setPiece(new Reine(EnumCouleurs.NOIR));
	 	this.tabCase[ligneNoir][5].setPiece(new Fou(EnumCouleurs.NOIR));
	 	this.tabCase[ligneNoir][6].setPiece(new Cavalier(EnumCouleurs.NOIR));
	 	this.tabCase[ligneNoir][7].setPiece(new Tour(EnumCouleurs.NOIR));
	 	
	 	this.tabCase[ligneBlanche][0].setPiece(new Tour(EnumCouleurs.BLANC));
	 	this.tabCase[ligneBlanche][1].setPiece(new Cavalier(EnumCouleurs.BLANC));
	 	this.tabCase[ligneBlanche][2].setPiece(new Fou(EnumCouleurs.BLANC));
	 	this.tabCase[ligneBlanche][3].setPiece(new Roi(EnumCouleurs.BLANC));
	 	this.tabCase[ligneBlanche][4].setPiece(new Reine(EnumCouleurs.BLANC));
	 	this.tabCase[ligneBlanche][5].setPiece(new Fou(EnumCouleurs.BLANC));
	 	this.tabCase[ligneBlanche][6].setPiece(new Cavalier(EnumCouleurs.BLANC));
	 	this.tabCase[ligneBlanche][7].setPiece(new Tour(EnumCouleurs.BLANC));
	}
	
}
