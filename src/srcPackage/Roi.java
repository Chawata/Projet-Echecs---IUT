/** Classe représentant un Roi et son comportement.
* @version 1.0 
* @author Husch Julien
*/

package srcPackage;

import java.util.ArrayList;

public class Roi extends Piece
{
	/**
	 * Créé un Roi de la couleur donnée en paramètre.
	 * @param couleur Couleur de type EnumCouleurs
	 */
	public Roi(EnumCouleurs couleur)    
	{        
		super(couleur);    
	}        

	/**
	 * Indique si un déplacement est possible pour un roi.
	 * @param caseDepart Case qui contient le Roi à déplacer.
	 * @param caseArrivee Case où l'on veut déplacer le Roi sélectionné.
	 */
	@Override
	public boolean deplacementPossible(Case caseDepart, Case caseArrivee)    
	{
		ArrayList<Case> casesPossibles = new ArrayList<Case>();
		final int x = caseDepart.getX();
		final int y = caseDepart.getY();
		
		for (int i = -1; i <= 1; ++i)
		{
			for (int j = -1; j <= 1; ++j)
			{
				// Cas particulier pour ne pas ajouter Case(x, y) aux cases où l'on peut se déplacer.
				if (i != 0 || j != 0)
				{
					casesPossibles.add(new Case(x + i, y + j));
				}
			}
		}
		
		return casesPossibles.contains(caseArrivee);
	}        

	@Override
	public String toString()    
	{        
		return "R" + super.toString();    
	}
} 
