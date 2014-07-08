/** Classe représentant un Pion et son comportement.
* @version 1.0 
* @author Husch Julien
*/

package srcPackage;

public class Pion extends Piece
{   
	/**
	 * Créé un Pion de la couleur demandée.
	 * @param couleur Couleur de type EnumCouleurs
	 */
	public Pion(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}
	
	/**
	 * Indique si le déplacement du pion est possible.
	 * @return true si un pion noir se déplace verticalement vers le bas, ou un pion blanc vers le haut, false sinon.
	 * @param caseDepart Case qui contient le Pion à déplacer.
	 * @param caseArrivee Case où l'on veut déplacer le Pion sélectionné.
	 */
	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{        
		if (this.getCouleur() == EnumCouleurs.NOIR)
		{
			return ((caseDepart.getX() == caseArrivee.getX()) && (caseArrivee.getY() == caseDepart.getY() + 1));
		}

		else if (this.getCouleur() == EnumCouleurs.BLANC)
		{
			return ((caseDepart.getX() == caseArrivee.getX()) && (caseArrivee.getY() == caseDepart.getY() - 1));
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
