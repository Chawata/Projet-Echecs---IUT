/**
* Classe Cavalier, qui émule le comportement d'une pièce Cavalier
* @version 1.0 
* @author Husch Julien
*/

package srcPackage;

public class Cavalier extends Piece
{
	/**
	 * Créé un cavalier de la couleur demandée.
	 * @param couleur Couleur de type EnumCouleurs.
	 */
	public Cavalier(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}

	/**
	 * Méthode vérifiant si le déplacement est possible.
	 * @return true si le quotient des deux déplacements (ligne et colonne) vaut 0.5 ou 2, false sinon.
	 * @param caseDepart La case où est situé le cavalier à bouger.
	 * @param caseArrivee La case où l'on souhaite déplacer le cavalier.
	 */
	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{
		double deplacementColonne = caseDepart.getY() - caseArrivee.getY();
		double deplacementLigne = caseDepart.getX() - caseArrivee.getX();

		double resultat = Math.abs(deplacementColonne) / Math.abs(deplacementLigne);
		
		if (deplacementColonne > 2 || deplacementLigne > 2)
		{
			return false;
		}
		
		return (resultat == 2) || (resultat == 0.5);
	}

	public String toString()    
	{        
		return "C" + super.toString();    
	}
} 
