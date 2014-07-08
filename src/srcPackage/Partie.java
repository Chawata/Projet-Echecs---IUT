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
		EnumCouleurs couleurDepart = caseDepart.getPiece().getCouleur();
		EnumCouleurs couleurArrivee = caseArrivee.getPiece().getCouleur();
	
		if(pieceDepart instanceof Pion)
		{
			if(couleurDepart.equals(couleurArrivee))
			{
				return false;
			}
	
			else
			{
				int deplacementColonne = caseDepart.getY() - caseArrivee.getY();
				int deplacementLigne = caseArrivee.getX() - caseArrivee.getX();
	
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
		Piece isPion = caseDepart.getPiece();
	
		if (isPion instanceof Pion)
		{
			if((caseDepart.getY() == 1 && (isPion.getCouleur() == EnumCouleurs.NOIR || ((caseDepart.getY() == 6  && (isPion.getCouleur() == EnumCouleurs.BLANC))))))
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
	
		if(!(caseArrivee.caseOccupee()) || couleurDepart != couleurArrivee)
		{
			if(!(pieceDepart instanceof Cavalier))
			{
				final int ligneDepart = caseDepart.getX();
				final int ligneArrivee = caseArrivee.getX();
				final int colonneDepart = caseDepart.getY();
				final int colonneArrivee = caseArrivee.getY();
				
				if(!(pieceDepart instanceof Pion))
				{
					if(ligneDepart == ligneArrivee && colonneDepart < colonneArrivee)
					{
						for(int i=colonneDepart+1;i<=colonneArrivee;i++)
						{
							if(this.echiquierPartie.getCase(ligneDepart,i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if(ligneDepart == ligneArrivee && colonneDepart > colonneArrivee)
					{
						for(int i=colonneDepart-1;i>=colonneArrivee;i--)
						{
							if(this.echiquierPartie.getCase(ligneDepart,i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if(colonneDepart == colonneArrivee && ligneDepart < ligneArrivee)
					{
						for(int i=ligneDepart+1;i<=ligneArrivee;i++)
						{
							if(this.echiquierPartie.getCase(ligneDepart,i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if(colonneDepart == colonneArrivee && ligneDepart > ligneArrivee)
					{
						for(int i=ligneDepart-1;i>=ligneArrivee;i--)
						{
							if(this.echiquierPartie.getCase(ligneDepart,i).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if(ligneArrivee<ligneDepart && colonneArrivee<colonneDepart)
					{
						int i = ligneDepart-1;
						int j = colonneDepart-1;
	
						while(i>=ligneArrivee && j>colonneArrivee)
						{
							if(this.echiquierPartie.getCase(i,j).caseOccupee())
							{
								return false;
							}
							i--;
							j--;
						}
					}
	
					if(ligneArrivee<ligneDepart && colonneArrivee>colonneDepart)
					{
						int i = ligneDepart-1;
						int j = colonneDepart+1;
	
						while(i>=ligneArrivee && j<colonneArrivee)
						{
							if(this.echiquierPartie.getCase(i,j).caseOccupee())
							{
								return false;
							}
							i--;
							j++;
						}
					}
	
					if(ligneArrivee>ligneDepart && colonneArrivee<colonneDepart)
					{
						int i = ligneDepart+1;
						int j = colonneDepart-1;
	
						while(i<=ligneArrivee && j>colonneArrivee)
						{
							if(this.echiquierPartie.getCase(i,j).caseOccupee())
							{
								return false;
							}
							i++;
							j--;
						}
					}
	
					if(ligneArrivee>ligneDepart && colonneArrivee>colonneDepart)
					{
						int i = ligneDepart+1;
						int j = colonneDepart+1;
	
						while(i<=ligneArrivee && j<colonneArrivee)
						{
							if(this.echiquierPartie.getCase(i,j).caseOccupee())
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
					if(this.echiquierPartie.getCase(ligneArrivee,colonneArrivee).caseOccupee())
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

		return true;
	}
	
	ArrayList<Case> obtenirPositionPiecesAdverses(EnumCouleurs couleurJoueur)
	{
		ArrayList<Case> result = new ArrayList<Case>();
		EnumCouleurs couleurAdverse = null;
		
		if (couleurJoueur == EnumCouleurs.BLANC)
		{
			couleurAdverse = EnumCouleurs.NOIR;
		}
		else
		{
			couleurAdverse = EnumCouleurs.BLANC;
		}
		
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
}
