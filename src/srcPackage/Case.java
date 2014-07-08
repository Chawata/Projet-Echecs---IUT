/*** @version 1.0
* @Anne-Sophie Segonds*/

package srcPackage;

public class Case
{	
	private int x;	
	private int y;	
	private Piece pieceC;

	public Case(int x, int y)	
	{		
		this.x = x;
		this.y = y;
		this.pieceC = null;
	}

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

	public void setX(int x)	
	{
		if (x >= 0 && x < Echiquier.Abscisses.size())
		{
			this.x = x;
		}
	}	

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

	public boolean caseOccupee()
	{
		return this.pieceC != null;
	}	
}
