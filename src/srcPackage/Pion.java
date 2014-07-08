/*** @version 1.0 
* @Husch Julien*/

package srcPackage;

public class Pion extends Piece
{    
	public Pion(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{        
		if (this.getCouleur() == EnumCouleurs.NOIR)
		{
			return ((caseDepart.getY() == caseArrivee.getY()) && (caseArrivee.getX() == caseDepart.getX() + 1));
		}

		else if (this.getCouleur() == EnumCouleurs.BLANC)
		{
			return ((caseDepart.getY() == caseArrivee.getY()) && (caseArrivee.getX() == caseDepart.getX() - 1));
		}
		
		else
		{
			return false;
		}
	}        

	public String toString()    
	{        
		return "pion " + super.toString();    
	}
} 
