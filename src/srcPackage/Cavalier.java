/*** @version 1.0 
* @Husch Julien*/

package srcPackage;

public class Cavalier extends Piece
{    
	public Cavalier(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	/**
	 * M�thode v�rifiant si le d�placement de la piece est possible.
         * Si le quotient des deux d�placement vaut 2 ou 5 alors la piece ait bien un deplacement en forme de L.
         */
	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{
		int deplacementcolonne = caseDepart.getY() - caseArrivee.getY();
		int deplacementligne = caseDepart.getX() - caseArrivee.getX();

		int resultat = Math.abs(deplacementcolonne) / Math.abs(deplacementligne);
		
		return (resultat == 2) || (resultat == 0.5);
	}

	public String toString()    
	{        
		return "cavalier " + super.toString();    
	}
} 
