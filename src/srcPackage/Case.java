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
	 * @param x La nouvelle abscisse
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
	 * @param y La nouvelle ordonnée
	 */
	public void setY(int y) 	
	{                
		if (y >= 0 && y < Echiquier.Ordonnees.size())
		{
			this.y = y;
		}       
	}
	
	/**
	 * Permet d'obtenir la pièce qu'il y a sur la case courante.
	 * @return La pièce qu'il y a sur cette case (ou null si rien)
	 */
	public Piece getPiece()
	{
		return this.pieceC;
	}

	/**
	 * Permet de modifier la pièce qu'il y a sur la case courante.
	 * @param piece Une pièce qui peut valoir null
	 */
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

	/**
	 * Teste l'égalité de deux cases en se basant sur leurs coordonnées.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		
		if (!(o instanceof Case))
		{
			return false;
		}
		
		Case c = (Case)o;
		return this.getX() == c.getX() && this.getY() == c.getY();
	}
	
	@Override
	public String toString()
	{
		if (this.caseOccupee())
		{
			return this.pieceC.toString();
		}
		else
		{
			return "  ";
		}
	}
}
