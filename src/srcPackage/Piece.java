/**
 * Classe abstraite représentant le concept de pièce. 
 * @author Ben Vittupier
 */

package srcPackage;

public abstract class Piece
{
    private EnumCouleurs couleur;

    public Piece(EnumCouleurs couleurPiece)
    {
        this.couleur = couleurPiece;
    }
    
    public abstract boolean deplacementPossible(Case caseDepart, Case caseArrivee);
    
    public EnumCouleurs getCouleur()
    {
        return this.couleur;
    }
    
    public String toString()
    { 
        return this.getCouleur().toString();
    }
}
