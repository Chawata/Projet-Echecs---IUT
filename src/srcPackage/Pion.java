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
	 * Indique si le déplacement du pion est possible ; si c'est le premier tour, on peut déplacer d'une ou deux cases.
	 * @return true si un pion noir se déplace verticalement vers le bas, ou un pion blanc vers le haut, false sinon.
	 * @param caseDepart Case qui contient le Pion à déplacer.
	 * @param caseArrivee Case où l'on veut déplacer le Pion sélectionné.
	 */
	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{
		final int ligneDepartNoir = 1;
		final int ligneDepartBlancs = 6;
		
		if (this.getCouleur() == EnumCouleurs.NOIR)
		{
			if((caseArrivee.getX() == caseDepart.getX() + 2) && (caseDepart.getX() == ligneDepartNoir) && (caseArrivee.getY() == caseDepart.getY()))
			{
				return true;
			}
			return ((caseDepart.getX() == caseArrivee.getX() - 1) && (caseArrivee.getY() == caseDepart.getY()));
		}

		else if (this.getCouleur() == EnumCouleurs.BLANC)
		{
			if((caseArrivee.getX() == caseDepart.getX() - 2) && (caseDepart.getX() == ligneDepartBlancs) && (caseArrivee.getY() == caseDepart.getY()))
			{
				return true;
			}
			return ((caseDepart.getX() == caseArrivee.getX() + 1) && (caseArrivee.getY() == caseDepart.getY()));
		}

		else
		{
			return false;
		}
	}

	public String toString()    
	{        
		return "P" + super.toString();    
	}
} 
