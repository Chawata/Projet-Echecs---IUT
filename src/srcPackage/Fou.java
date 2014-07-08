/*** @version 1.0 
* @Husch Julien*/

package srcPackage;

public class Fou extends Piece
{    
	public Fou(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{
		int deplacementColonne = caseDepart.getY() - caseArrivee.getY();
		int deplacementLigne = caseDepart.getX() - caseArrivee.getX();

		return (Math.abs(deplacementColonne) - Math.abs(deplacementLigne)) == 0;
	}        

	public String toString()    
	{        
		return "fou " + super.toString();    
	}
} 
