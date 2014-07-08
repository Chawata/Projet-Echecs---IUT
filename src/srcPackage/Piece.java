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
        if (this.getCouleur() == EnumCouleurs.NOIR)
            return "noir";
        else
            return "blanc";
    }
}
