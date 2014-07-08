/** Classe représentant un Roi et son comportement.
* @version 1.0 
* @author Husch Julien
*/

package srcPackage;

public class Roi extends Piece
{
	/**
	 * Créé un Roi de la couleur donnée en paramètre.
	 * @param couleur Couleur de type EnumCouleurs
	 */
	public Roi(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	/**
	 * Indique si un déplacement est possible pour un roi.
	 * @param caseDepart Case qui contient le Roi à déplacer.
	 * @param caseArrivee Case où l'on veut déplacer le Roi sélectionné.
	 */
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
