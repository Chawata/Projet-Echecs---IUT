package srcPackage;

import java.util.ArrayList;

public class Partie
{
    private Echiquier echiquierPartie; 
    
    private ArrayList<Case> coupsJoues;

    private Joueur[] joueurs;

    //ArrayList<Piece> piece_J1;
    //ArrayList<Piece> piece_J2;
    
    
    public Partie()
    {
    	this.echiquierPartie = new Echiquier();
    	this.coupsJoues = new ArrayList<Case>();
    	
    	this.joueurs = new Joueur[2];
    	for (int i = 0; i < this.joueurs.length; ++i)
    	{
    		this.joueurs[i] = new Joueur();
    	}
    }
    
    public Partie(Echiquier e)
    {
    	this.echiquierPartie = e;
    	this.coupsJoues = new ArrayList<Case>();
    	
    	this.joueurs = new Joueur[2];
    	for (int i = 0; i < this.joueurs.length; ++i)
    	{
    		this.joueurs[i] = new Joueur();
    	}
    }
    
    public void init()
    {
    	this.echiquierPartie.initialiserEchiquier();
    	for (int i = 0; i < this.joueurs.length; ++i)
    	{
    		System.out.println("Information du joueur " + (i + 1));
    		this.joueurs[i].initialiserJoueur();
    	}
    }
    
    public boolean pionPeutPrendre(Case caseDepart, Case caseArrivee)
    {
		Piece pieceDepart = caseDepart.getPiece();
		EnumCouleurs couleurDepart = pieceDepart.getCouleur();
		EnumCouleurs couleurArrivee;
		
		Piece pieceArrivee = caseArrivee.getPiece();
		if (pieceArrivee == null)
		{
			couleurArrivee = null;
		}
		else
		{
			couleurArrivee =  pieceArrivee.getCouleur();
		}
		
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
	
				if (couleurDepart == EnumCouleurs.BLANC)
				{
					if (caseArrivee.getX() >= caseDepart.getX())
					{
						return false;
					}
				}
				
				if (couleurDepart == EnumCouleurs.NOIR)
				{
					if (caseArrivee.getX() <= caseDepart.getX())
					{
						return false;
					}
				}
				
				return (Math.abs(deplacementColonne)) * (Math.abs(deplacementLigne)) == 1;
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
			if (piece.getCouleur() == EnumCouleurs.NOIR && caseDepart.getX() == ligneDepartNoir)
			{
				return true;
			}
			
			else if (piece.getCouleur() == EnumCouleurs.BLANC && caseDepart.getX() == ligneDepartBlancs)
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
		EnumCouleurs couleurArrivee;
		
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
							if(this.echiquierPartie.getCase(i, colonneDepart).caseOccupee())
							{
								return false;
							}
						}
					}
	
					if (colonneDepart == colonneArrivee && ligneDepart > ligneArrivee)
					{
						for (int i = ligneDepart - 1; i > ligneArrivee; i--)
						{
							if(this.echiquierPartie.getCase(i, colonneDepart).caseOccupee())
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
			while (caseRoi == null && j < Echiquier.Ordonnees.size())
			{
				Piece pieceTemp = this.echiquierPartie.getCase(i, j).getPiece();
				if ((pieceTemp instanceof Roi) && (pieceTemp.getCouleur() == couleur))
				{
					caseRoi = new Case(i, j, pieceTemp);
				}
				else
				{
					++j;
				}
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
			Case casePieceAdverse = piecesAdverses.get(i);
			Piece piece = casePieceAdverse.getPiece();
			
			if (piece instanceof Pion)
			{
				if (this.pionPeutPrendre(casePieceAdverse, caseRoi))
				{
					result = true;
				}
			}
			else
			{
				if (piece.deplacementPossible(casePieceAdverse, caseRoi) && this.deplacementNonGene(casePieceAdverse, caseRoi))
				{
					result = true;
				}
			}
			
			++i;
		}
		
		return result;
	}
	
	public boolean isEchecEtmat(EnumCouleurs couleur)
	{
		int nbEchec = 0;
		int nbDeplacement = 0;
		Piece roi = new Roi(couleur);
		Case caseKing = this.getPositionRoi(couleur);
		
		for(int x = -1; x <= 1; x++)
		{	
			for(int y = -1; y <= 1; y++)
			{
				if (caseKing.getX() + x >= 0 && caseKing.getX() + x <= 7 && caseKing.getY() + y >= 0 && caseKing.getY() + y <= 7)
				{
					final int caseArriveeX = caseKing.getX() + x;
					final int caseArriveeY = caseKing.getY() + y;
					Case caseArrivee = new Case(caseArriveeX, caseArriveeY, this.echiquierPartie.getCase(caseArriveeX, caseArriveeY).getPiece());
					
					if (roi.deplacementPossible(caseKing, caseArrivee) && this.deplacementNonGene(caseKing, caseArrivee))
					{
						if (x != 0 || y != 0)
						{
							++nbDeplacement;
							int xKingInter = caseKing.getX() + x;
							int yKingInter = caseKing.getY() + y;
								
							Piece tempPiece = this.echiquierPartie.getCase(xKingInter, yKingInter).getPiece();
								
							if (tempPiece == null)
							{
								Case caseKingInter = new Case(xKingInter, yKingInter, roi);
								this.echiquierPartie.setCase(caseKingInter);
		
								if (this.isEchec(couleur))
								{
									nbEchec++;
								}
										
								Case caseReplace = new Case(xKingInter, yKingInter, null);
								this.echiquierPartie.setCase(caseReplace);
							}
						}
					}
				}

			}
		}

		return nbEchec == nbDeplacement && nbEchec != 0;
	}
	
	private EnumCouleurs getCouleurJoueur(Joueur joueurCourant)
	{
		if (joueurCourant.equals(this.joueurs[0]))
		{
			return EnumCouleurs.BLANC;
		}
		else
		{
			return EnumCouleurs.NOIR;
		}
	}
	
	private Case saisirBonneCaseDepart(Joueur joueurCourant)
	{
		boolean isValid = false;
		Case caseDepart = null;
		EnumCouleurs couleurJoueur = this.getCouleurJoueur(joueurCourant);
		
		while (!isValid)
		{
			Case caseTemp = joueurCourant.saisirCaseDepart();
			caseDepart = this.echiquierPartie.getCase(caseTemp.getX(), caseTemp.getY()); 
			
			if (caseDepart.getPiece() == null )
			{
				System.out.println("La case sélectionnée est vide, merci de choisir une case avec un pion.");
			}
			else if (caseDepart.getPiece().getCouleur() != couleurJoueur)
			{
				System.out.println("La case de départ contient une pièce qui ne vous appartient pas, merci de recommencer.");
			}
			else
			{
				isValid = true;
			}
		}
		
		return caseDepart;
	}

	public boolean jouerTour(Joueur joueurCourant)
	{
		EnumCouleurs couleurJoueur = this.getCouleurJoueur(joueurCourant);
		boolean isEchec = this.isEchec(couleurJoueur);
		boolean peutContinuer = true;
		
		if (isEchec)
		{
			if (this.isEchecEtmat(couleurJoueur))
			{
				peutContinuer = false;
			}
			else
			{
				System.out.println("Attention, votre Roi est en échec !");
				while (isEchec)
				{
					System.out.println("Faite un déplacement de manière à ce que votre Roi ne soit plus en échec.");
					Case caseDepart = this.saisirBonneCaseDepart(joueurCourant);
					Piece pieceDepart = caseDepart.getPiece();
					Case caseArrivee = joueurCourant.saisirCaseArrivee();
					Piece pieceArrivee = caseArrivee.getPiece();
					
					while (pieceDepart.getCouleur() == pieceArrivee.getCouleur())
					{
						System.out.println("On ne peut pas manger une pièce de la même couleur. Veuillez recommencer.");
						caseDepart = this.saisirBonneCaseDepart(joueurCourant);
						pieceDepart = caseDepart.getPiece();
						caseArrivee = joueurCourant.saisirCaseArrivee();
						pieceArrivee = caseArrivee.getPiece();
					}
					
					while (!(pieceDepart.deplacementPossible(caseDepart, caseArrivee)) && !(this.deplacementNonGene(caseDepart, caseArrivee)))
					{
						System.out.println("Le déplacement n'est pas valide, merci de recommencer.");
					}
					
					caseDepart.setPiece(null);
					caseArrivee.setPiece(pieceDepart);
					this.echiquierPartie.setCase(caseDepart);
					this.echiquierPartie.setCase(caseArrivee);
					
					if (!this.isEchec(couleurJoueur))
					{
						isEchec = false;
					}
					else
					{
						caseDepart.setPiece(pieceDepart);
						caseArrivee.setPiece(null);
						System.out.println("Ce déplacement ne peut être effectué car Roi sera toujours en échec.");
					}
					
					this.echiquierPartie.setCase(caseDepart);
					this.echiquierPartie.setCase(caseArrivee);
					
					if (this.isEchecEtmat(couleurJoueur))
					{
						peutContinuer = false;
					}
				}
			}
		}
		else
		{
			Case caseDepart = this.saisirBonneCaseDepart(joueurCourant);
			Piece pieceDepart = caseDepart.getPiece();
			Case caseArrivee = joueurCourant.saisirCaseArrivee();
			caseArrivee.setPiece(this.echiquierPartie.getCase(caseArrivee.getX(), caseArrivee.getY()).getPiece());
			Piece pieceArrivee = caseArrivee.getPiece();
			
			if (this.pionPeutPrendre(caseDepart, caseArrivee))
			{
				caseDepart.setPiece(null);
				caseArrivee.setPiece(pieceDepart);
				this.echiquierPartie.setCase(caseDepart);
				this.echiquierPartie.setCase(caseArrivee);
			}
			else
			{
				while (!pieceDepart.deplacementPossible(caseDepart, caseArrivee))
				{
					System.out.println("Le déplacement n'est pas valide, merci de recommencer.");
					caseDepart = this.saisirBonneCaseDepart(joueurCourant);
					pieceDepart = caseDepart.getPiece();
					caseArrivee = joueurCourant.saisirCaseArrivee();
				}
				
				while (!(this.deplacementNonGene(caseDepart, caseArrivee)))
				{
					System.out.println("Le déplacement n'est pas possible sur la case choisie.");
					caseDepart = this.saisirBonneCaseDepart(joueurCourant);
					pieceDepart = caseDepart.getPiece();
					caseArrivee = joueurCourant.saisirCaseArrivee();
				}
			}
			
			caseDepart.setPiece(null);
			caseArrivee.setPiece(pieceDepart);
			this.echiquierPartie.setCase(caseDepart);
			this.echiquierPartie.setCase(caseArrivee);
		}
		
		return peutContinuer;
	}
	
	private Joueur prochainJoueur(Joueur joueurCourant)
	{
		if (joueurCourant.equals(this.joueurs[0]))
		{
			return this.joueurs[1];
		}
		else
		{
			return this.joueurs[0];
		}
	}
	
	public void jouer()
	{
		Joueur joueurCourant = this.joueurs[0];
		boolean estTerminee = false;
		
		while (!estTerminee)
		{
			System.out.println("\n" + this.echiquierPartie);
			System.out.println("Au tour de " + joueurCourant + " jouer."); 
			
			if (!this.jouerTour(joueurCourant))
			{
				estTerminee = true;
			}
			
			if (!estTerminee)
			{
				joueurCourant = this.prochainJoueur(joueurCourant);
			}
		}
		
		System.out.println("Le joueur " + joueurCourant + " est échec et mat !");
		System.out.println("Le joueur " + this.prochainJoueur(joueurCourant) + " remporte la partie !");
	}
}
