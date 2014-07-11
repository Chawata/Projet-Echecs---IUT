/** Classe représentant une Reine et son comportement.
* @version 1.0 
* @author Husch Julien
*/

package srcPackage;

public class Reine extends Piece
{
	/**
	 * Créé une reine de la couleur donnée en paramètre.
	 * @param couleur Couleur de type EnumCouleurs
	 */
	public Reine(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	/**
	 * Indique si un déplacement est possible pour une reine.
	 * @return true si le résultat vaut 0, si l'abscisse de départ et d'arrivée sont identiques ou si l'ordonnée de départ et d'arrivée sont identiques, false sinon.
	 * @param caseDepart Case qui contient la Reine à déplacer.
	 * @param caseArrivee Case où l'on veut déplacer la Reine sélectionnée.
	 */
	@Override
	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{
		int deplacementcolonne = caseDepart.getY() - caseArrivee.getY();
		int deplacementligne = caseDepart.getX() - caseArrivee.getX();
		
		int resultat = Math.abs(deplacementcolonne) - Math.abs(deplacementligne);

		return (resultat == 0) || (caseDepart.getX() == caseArrivee.getX()) || (caseDepart.getY() == caseArrivee.getY());
	}        

	@Override
	public String toString()    
	{        
		return "D" + super.toString();    
	}
} 
