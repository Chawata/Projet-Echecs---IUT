package srcPackage;

public class Tour extends Piece
{
    public Tour(EnumCouleurs couleur)
    {
        super(couleur);
    }
    
    public boolean deplacementPossible(Case caseDepart, Case caseArrivee)
    {
        return (caseDepart.getX() == caseArrivee.getX()) || (caseDepart.getY() == caseArrivee.getY());
    }
    
    public String toString()
    {
        return "tour " + super.toString();
    }
}