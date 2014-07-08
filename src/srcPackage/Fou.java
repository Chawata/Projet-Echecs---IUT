/**
* Classe représentant un Fou et le comportement associé.
* @version 1.0 
* @author Husch Julien
*/

package srcPackage;

public class Fou extends Piece
{
	/**
	 * Créé un fou de la couleur donnée en paramètre.
	 * @param couleur Couleur de type EnumCouleurs
	 */
	public Fou(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}
	
	/**
	 * Indique si un déplacement est possible pour un fou.
	 * @return true si la différence déplacementColonne - déplacementLigne vaut 0, false sinon.
	 * @param caseDepart Case qui contient le Fou à déplacer.
	 * @param caseArrivee Case où l'on veut déplacer le Fou sélectionné.
	 */
	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{
		int deplacementColonne = caseDepart.getY() - caseArrivee.getY();
		int deplacementLigne = caseDepart.getX() - caseArrivee.getX();

		return (Math.abs(deplacementColonne) - Math.abs(deplacementLigne)) == 0;
	}        

	public String toString()    
	{        
		return "F" + super.toString();    
	}
} 
