/*** @version 1.0 
* @Husch Julien*/

package srcPackage;

public class Reine extends Piece
{    
	public Reine(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{        
		int deplacementcolonne = caseDepart.getY() - caseArrivee.getY();
		int deplacementligne = caseDepart.getX() - caseArrivee.getX();
		
		int resultat = Math.abs(deplacementcolonne) - Math.abs(deplacementligne);

		return (resultat == 0) || (caseDepart.getX() == caseArrivee.getX()) || (caseDepart.getY() == caseArrivee.getY());
	}        

	public String toString()    
	{        
		return "reine " + super.toString();    
	}
} 
