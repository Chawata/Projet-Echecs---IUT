package srcPackage;

import java.util.ArrayList;

public class Partie
{
    private Echiquier echiquierPartie; 

    //private Joueur joueurJ1;
    //private Joueur joueurJ2;

    //ArrayList<Piece> piece_J1;
    //ArrayList<Piece> piece_J2;
    
    //Tableau à 2 dimensions contenant les coups joués.
    int tabCoup [][];
    
    public Partie()
    {
    	this.echiquierPartie = new Echiquier();
    }
    
    public Partie(Echiquier e)
    {
    	this.echiquierPartie = e;
    }
    
    public boolean pionPeutPrendre(Case caseDepart, Case caseArrivee)
    {
		Piece pieceDepart = caseDepart.getPiece();
		EnumCouleurs couleurDepart = pieceDepart.getCouleur();
		EnumCouleurs couleurArrivee = caseArrivee.getPiece().getCouleur();
	
		if(pieceDepart instanceof Pion)
		{
			if (couleurDepart == couleurArrivee)
			{
				return false;
			}
	
			else
			{
				int deplacementColonne = caseDepart.getY() - caseArrivee.getY();
				int deplacementLigne = caseDepart.getX() - caseArrivee.getX();
	
				int resultat = (Math.abs(deplacementColonne)) * (Math.abs(deplacementLigne));
	
				return (resultat == 1 || resultat == -1);
			}
		}
		else
		{
			return false;
		}
    }

	public boolean isPremierDeplacementPion(Case caseDepart)
	{
		Piece piece = caseDepart.getPiece();
		final int ligneDepartNoir = 1;
		final int ligneDepartBlancs = 6;
	
		if (piece instanceof Pion)
		{
			if (piece.getCouleur() == EnumCouleurs.NOIR && caseDepart.getY() == ligneDepartNoir)
			{
				return true;
			}
			
			else if (piece.getCouleur() == EnumCouleurs.BLANC && caseDepart.getY() == ligneDepartBlancs)
			{
				return true;
			}
			
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}


	public boolean deplacementNonGene(Case caseDepart, Case caseArrivee)
	{
		Piece pieceDepart = caseDepart.getPiece();
		EnumCouleurs couleurDepart = caseDepart.getPiece().getCouleur();
		EnumCouleurs couleurArrivee;// = caseArrivee.getPiece().getCouleur();
		
		Piece pieceArrivee = caseArrivee.getPiece();
		if(pieceArrivee == null)
		{
			couleurArrivee = null;
		}
		else
		{
			couleurArrivee = caseArrivee.getPiece().getCouleur();
		}
	
		if (!(caseArrivee.caseOccupee()) || couleurDepart != couleurArrivee)
		{
			if (!(pieceDepart instanceof Cavalier))
			{
				final int ligneDepart = caseDepart.getX();
				final int ligneArrivee = caseArrivee.getX();
				final int colonneDepart = caseDepart.getY();
				final int colonneArrivee = caseArrivee.getY();
				
				if (!(pieceDepart instanceof Pion))
				{
					if (ligneDepart == ligneArrivee && colonneDepart < colonneArrivee)
					{
						for (int i = colonneDepart + 1; i < colonneArrivee; i++)
						{
							if(this.echiquierPartie.getCase(ligneDepart, i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if (ligneDepart == ligneArrivee && colonneDepart > colonneArrivee)
					{
						for (int i = colonneDepart - 1; i > colonneArrivee; i--)
						{
							if (this.echiquierPartie.getCase(ligneDepart, i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if (colonneDepart == colonneArrivee && ligneDepart < ligneArrivee)
					{
						for (int i = ligneDepart + 1; i < ligneArrivee; i++)
						{
							if(this.echiquierPartie.getCase(ligneDepart, i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if (colonneDepart == colonneArrivee && ligneDepart > ligneArrivee)
					{
						for (int i = ligneDepart - 1; i > ligneArrivee; i--)
						{
							if(this.echiquierPartie.getCase(ligneDepart, i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if (ligneArrivee < ligneDepart && colonneArrivee < colonneDepart)
					{
						int i = ligneDepart - 1;
						int j = colonneDepart - 1;
	
						while (i > ligneArrivee && j > colonneArrivee)
						{
							if (this.echiquierPartie.getCase(i, j).caseOccupee())
							{
								return false;
							}
							i--;
							j--;
						}
					}
	
					if (ligneArrivee < ligneDepart && colonneArrivee > colonneDepart)
					{
						int i = ligneDepart - 1;
						int j = colonneDepart + 1;
	
						while(i > ligneArrivee && j < colonneArrivee)
						{
							if (this.echiquierPartie.getCase(i, j).caseOccupee())
							{
								return false;
							}
							i--;
							j++;
						}
					}
	
					if (ligneArrivee > ligneDepart && colonneArrivee < colonneDepart)
					{
						int i = ligneDepart + 1;
						int j = colonneDepart - 1;
	
						while (i < ligneArrivee && j > colonneArrivee)
						{
							if (this.echiquierPartie.getCase(i, j).caseOccupee())
							{
								return false;
							}
							i++;
							j--;
						}
					}
	
					if (ligneArrivee > ligneDepart && colonneArrivee > colonneDepart)
					{
						int i = ligneDepart + 1;
						int j = colonneDepart + 1;
	
						while(i < ligneArrivee && j < colonneArrivee)
						{
							if (this.echiquierPartie.getCase(i, j).caseOccupee())
							{
								return false;
							}
							i++;
							j++;
						}
					}
				}
				else
				{
					if(this.echiquierPartie.getCase(ligneArrivee, colonneArrivee).caseOccupee())
					{
						return false;
					}
	
					else
					{
						return true;
					}
				}
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}

		return true;
	}
	
	public ArrayList<Case> obtenirPositionPiecesAdverses(EnumCouleurs couleurJoueur)
	{
		ArrayList<Case> result = new ArrayList<Case>();
		EnumCouleurs couleurAdverse = EnumCouleurs.getOpposite(couleurJoueur);
		
		for (int i = 0; i < Echiquier.Abscisses.size(); ++i)
		{
			for (int j = 0; j < Echiquier.Ordonnees.size(); ++j)
			{
				Case caseCourante = echiquierPartie.getCase(i, j);
				Piece pieceCaseCourante = caseCourante.getPiece();
				
				if (pieceCaseCourante != null && pieceCaseCourante.getCouleur() == couleurAdverse)
				{
					result.add(caseCourante);
				}
			}
		}
		
		return result;
	}
	
	public Case getPositionRoi(EnumCouleurs couleur)
	{
		Case caseRoi = null;
		
		int i = 0;
		while (caseRoi == null && i < Echiquier.Abscisses.size())
		{
			int j = 0;
			while (j < Echiquier.Ordonnees.size())
			{
				Piece pieceTemp = this.echiquierPartie.getCase(i, j).getPiece();
				if ((pieceTemp instanceof Roi) && (pieceTemp.getCouleur() == couleur))
				{
					caseRoi = new Case(i, j, pieceTemp);
				}
				
				++j;
			}
			
			++i;
		}
		
		return caseRoi;
	}
	
	public boolean isEchec(EnumCouleurs couleurRoi)
	{
		Case caseRoi = this.getPositionRoi(couleurRoi);
		boolean result = false;
		int i = 0;
		
		ArrayList<Case> piecesAdverses = this.obtenirPositionPiecesAdverses(couleurRoi);
	 
		while (i < piecesAdverses.size() && !result)
		{
			Case casePiece = piecesAdverses.get(i);
			Piece piece = casePiece.getPiece();
			
			if (piece.deplacementPossible(casePiece, caseRoi) && this.deplacementNonGene(casePiece, caseRoi))
			{
				result = true;
			}
			else
			{
				++i;
			}
		}
		
		return result;
	}
	
	public boolean isEchecEtmat(EnumCouleurs couleur)
	{
		int nbEchec = 0;
		Piece roi = new Roi(couleur);
		Case caseKing = this.getPositionRoi(couleur);

		for(int x = -1; x<=1; x++)
		{	
			for(int y = -1; y<=1; y++)
			{
				if(caseKing.getX()+x>=0 && caseKing.getX()+x<=7 && caseKing.getY()+y>=0 && caseKing.getY()+y<=7)
				{
					int xKingInter = caseKing.getX()+x;
					int yKingInter = caseKing.getY()+y;
					if(this.echiquierPartie.getCase(xKingInter, yKingInter).getPiece() == null)
					{
						Case caseKingInter = new Case(xKingInter, yKingInter, roi);
						this.echiquierPartie.setCase(caseKingInter);

						if(this.isEchec(couleur))
						{
							nbEchec++;
						}
						Case caseReplace = new Case(xKingInter, yKingInter, null);
						this.echiquierPartie.setCase(caseReplace);
					}
				}

			}
		}

		return nbEchec == 8;
	}
}
