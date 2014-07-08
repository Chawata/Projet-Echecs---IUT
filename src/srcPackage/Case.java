/**
* Classe Case, qui représente une case de l'échiquier et son comportement associé.
* @version 1.0
* @author Anne-Sophie Segonds
*/

package srcPackage;

public class Case
{	
	private int x;	
	private int y;	
	private Piece pieceC;

	/**
	 * Créé une case située aux coordonnées (x ; y) vide.
	 * @param x L'abscisse de la case
	 * @param y L'ordonnée de la case
	 */
	public Case(int x, int y)	
	{		
		this.x = x;
		this.y = y;
		this.pieceC = null;
	}

	/**
	 * Créé une case située aux coordonnées (x ; y) avec une pièce dessus.
	 * @param x L'abscisse de la case
	 * @param y L'ordonnée de la case
	 * @param piece La pièce à placer sur cette case.
	 */
	public Case(int x, int y, Piece piece)	
	{		
		this.x = x;		
		this.y = y;		
		this.pieceC = piece;	
	}	

	public int getX()	
	{		
		return this.x;	
	}	

	public int getY()	
	{		
		return this.y;	
	}	

	/**
	 * Change l'abscisse de la case uniquement si la valeur fournie est correcte.
	 * @param x
	 */
	public void setX(int x)	
	{
		if (x >= 0 && x < Echiquier.Abscisses.size())
		{
			this.x = x;
		}
	}	

	/**
	 * Change l'ordonnée de la case uniquement si la valeur fournie est correcte.
	 * @param y
	 */
	public void setY(int y) 	
	{                
		if (y >= 0 && y < Echiquier.Ordonnees.size())
		{
			this.y = y;
		}       
	}

	public Piece getPiece()
	{
		return this.pieceC;
	}

	public void setPiece(Piece piece)
	{
		this.pieceC = piece;
	}

	/**
	 * Indique si la case actuelle est occupée par une pièce ou non.
	 * @return true si la case est occupée, false sinon.
	 */
	public boolean caseOccupee()
	{
		return this.pieceC != null;
	}	
}
