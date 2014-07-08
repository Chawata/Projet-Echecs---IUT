/*** @version 1.0 
* @Husch Julien*/

package srcPackage;

public class Roi extends Piece
{    
	public Roi(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{        
		int deplacementcolonne = caseDepart.getY() - caseArrivee.getY();
		int deplacementligne = caseDepart.getX() - caseArrivee.getX();

		int resultat = Math.abs(deplacementcolonne) - Math.abs(deplacementligne);
		
		if ((resultat == 0 && caseArrivee.getY() == caseDepart.getY()+1) || (resultat == 0 && caseArrivee.getY() == caseDepart.getY()-1) || (resultat == 1 && caseArrivee.getX() == caseDepart.getX()+1) || (resultat == 1 && caseArrivee.getX() == caseDepart.getX()-1) || (resultat == -1 && caseArrivee.getX() == caseDepart.getX()+1) || (resultat == -1 && caseArrivee.getX() == caseDepart.getX()-1))
		{	
			return true;
		}
		
		else
		{
			return false;
		} 
	}        

	public String toString()    
	{        
		return "roi " + super.toString();    
	}
} 
