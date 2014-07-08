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
		int deplacementcolonne = caseDepart.getY() - caseArrivee.getY();
		int deplacementligne = caseDepart.getX() - caseArrivee.getX();

		int resultat = Math.abs(deplacementcolonne) / Math.abs(deplacementligne);
		
		return (resultat == 2) || (resultat == 0.5);
	}

	public String toString()    
	{        
		return "C" + super.toString();    
	}
} 
