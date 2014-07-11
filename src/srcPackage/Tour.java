/** Classe représentant une Tour et son comportement.
* @version 1.0 
* @author Husch Julien
*/

package srcPackage;

public class Tour extends Piece
{
	/**
	 * Créé une tour de la couleur donnée en paramètre.
	 * @param couleur Couleur de type EnumCouleurs
	 */
    public Tour(EnumCouleurs couleur)
    {
        super(couleur);
    }
    
    /**
	 * Indique si un déplacement est possible pour une tour.
	 * @return true si l'abscisse de départ et d'arrivée sont identiques ou si l'ordonnée de départ et d'arrivée sont identiques.
	 * @param caseDepart Case qui contient la Tour à déplacer.
	 * @param caseArrivee Case où l'on veut déplacer la Tour sélectionnée.
	 */
    @Override
    public boolean deplacementPossible(Case caseDepart, Case caseArrivee)
    {
        return (caseDepart.getX() == caseArrivee.getX()) || (caseDepart.getY() == caseArrivee.getY());
    }
    
    @Override
    public String toString()
    {
        return "T" + super.toString();
    }
}
