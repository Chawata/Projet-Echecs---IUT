/**
 * Classe principale car c'est elle qui fait jouer les tours, vérifie si le roi est en échec ou en échec
 * et mat, etc.
 * @author Anne-Sophie Segonds
 * @author Julien Husch
 * @author Ben Vittupier
 */

package srcPackage;

import java.util.ArrayList;

public class Partie
{
    private Echiquier echiquierPartie; 

    private Joueur[] joueurs;

    /**
     * Constructeur par défaut de la classe Partie, qui appelle les constructeurs par défaut de Echiquier et Joueur.
     */
    public Partie()
    {
    	this.echiquierPartie = new Echiquier();
    	
    	this.joueurs = new Joueur[2];
    	for (int i = 0; i < this.joueurs.length; ++i)
    	{
    		this.joueurs[i] = new Joueur();
    	}
    }
    
    /**
     * /!\ Méthode à ne pas utiliser en dehors des tests JUNIT ! /!\ 
     * Constructeur prenant un échiquier en paramètre et faisant appel aux constructeurs par défaut de Joueur.
     * @param e Un échiquier différent de null
     */
    public Partie(Echiquier e)
    {
    	this.echiquierPartie = e;
    	
    	this.joueurs = new Joueur[2];
    	for (int i = 0; i < this.joueurs.length; ++i)
    	{
    		this.joueurs[i] = new Joueur();
    	}
    }
    
    /**
     * Méthode qui initialise l'échiquier et les données sur les joueurs.
     */
    public void init()
    {
    	this.echiquierPartie.initialiserEchiquier();
    	for (int i = 0; i < this.joueurs.length; ++i)
    	{
    		System.out.println("Information du joueur " + (i + 1));
    		this.joueurs[i].initialiserJoueur();
    	}
    }
    
    /**
     * Méthode qui vérifie si un pion sur une de départ peut prendre une pièce sur un case d'arrivée.
     * @param caseDepart Case où se situe un pion. Si celle-ci ne contient pas un pion, elle renvoie false.
     * @param caseArrivee Case où l'on veut déplacer le pion.
     * @return false si la case de départ ne contient pas un pion ou si il ne peut pas prendre la pièce sur la case d'arrivée, true sinon
     */
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
	
				// Tests pour éviter de pouvoir prendre des pièces situés derrière le pion
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

    /**
     * Retourne un boolean indiquant si c'est le premier déplacement du pion situé sur la caseDépart.
     * @param caseDepart Une case 
     * @return false si caseDépart ne contient pas un pion ou s'il n'est plus sur la ligne de départ des pions, true sinon.
     */
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

	/**
	 * Méthode qui indique si rien ne gène le déplacement d'une case de départ à une case d'arrivée.
	 * @param caseDepart La case de départ
	 * @param caseArrivee La case d'arrivée
	 * @return false si quelque chose gène le déplacement, true sinon
	 */
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
	
	/**
	 * Méthode qui retourne les cases sur lesquelles sont situées les pièces adverses.
	 * @param couleurJoueur La couleur du joueur au tour (si le joueur au tour est BLANC, alors on retourne la position des pièces NOIRES)
	 * @return Un ArrayList de Case contenant les cases sur lesquelles sont situées les pièces adverses.
	 */
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
	
	/**
	 * Retourne la case contenant le roi de couleur passée en paramètre.
	 * @param couleur La couleur du roi qu'on veut récupérer.
	 * @return La Case sur laquelle est le roi, null si il n'est pas sur l'échiquier (ne devrait jamais arriver)
	 */
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
	
	/**
	 * Retourne si le roi de couleur passée en paramètre est en échec.
	 * @param couleurRoi La couleur du roi dont il faut tester l'échec.
	 * @return true si le roi est en échec, false sinon
	 */
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
	
	/**
	 * Retourne si le roi de couleur passée en paramètre est en échec et mat.
	 * @param couleur La couleur du roi dont il faut tester l'échec et mat.
	 * @return true si le roi est en échec et mat, false sinon
	 */
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
	
	/**
	 * Retourne la couleur du joueur courant.
	 * @param joueurCourant Le joueur courant
	 * @return Couleur du joueur courant
	 */
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
	
	/**
	 * Méthode qui redemande la saisie de la case de départ tant que celle-ci n'est pas bonne.
	 * @param joueurCourant Le joueur courant
	 * @return La Case saisie par le joueur courant
	 */
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

	/**
	 * Cette méthode fait jouer le tour du joueur courant et retourne s'il peut continuer à jouer ou non.
	 * @param joueurCourant Le joueur au trait
	 * @return true si le joueur peut encore jouer, false si celui-ci est en échec et mat
	 */
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
					
					// On teste si on ne tente pas de manger une pièce alliée
					while (pieceDepart.getCouleur() == pieceArrivee.getCouleur())
					{
						System.out.println("On ne peut pas manger une pièce de la même couleur. Veuillez recommencer.");
						caseDepart = this.saisirBonneCaseDepart(joueurCourant);
						pieceDepart = caseDepart.getPiece();
						caseArrivee = joueurCourant.saisirCaseArrivee();
						pieceArrivee = caseArrivee.getPiece();
					}
					
					// On test ensuite si le déplacement est possible
					while (!pieceDepart.deplacementPossible(caseDepart, caseArrivee))
					{
						System.out.println("Le déplacement n'est pas valide, merci de recommencer.");
						caseDepart = this.saisirBonneCaseDepart(joueurCourant);
						pieceDepart = caseDepart.getPiece();
						caseArrivee = joueurCourant.saisirCaseArrivee();
					}
					
					// On teste enfin si le déplacement n'est pas gêné sur son chemin
					while (!(this.deplacementNonGene(caseDepart, caseArrivee)))
					{
						System.out.println("Le déplacement n'est pas possible sur la case choisie.");
						caseDepart = this.saisirBonneCaseDepart(joueurCourant);
						pieceDepart = caseDepart.getPiece();
						caseArrivee = joueurCourant.saisirCaseArrivee();
					}
					
					// Si toute les conditions sont bonnes, on teste en déplacement la pièce de caseDépart à caseArrivée
					// si le roi est encore en échec ou non
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
						this.echiquierPartie.setCase(caseDepart);
						this.echiquierPartie.setCase(caseArrivee);
						
						System.out.println("Ce déplacement ne peut être effectué car Roi sera toujours en échec.");
					}	
					
					if (this.isEchecEtmat(couleurJoueur))
					{
						peutContinuer = false;
						isEchec = false;
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
			
			// Si l'on a affaire à une autre pièce qu'un pion, on fait des test supplémentaires, sinon on
			// met directement l'échiquier à jour.
			if (!this.pionPeutPrendre(caseDepart, caseArrivee))
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
	
	/**
	 * Retourne le prochain joueur
	 * @param joueurCourant Le joueur au trait
	 * @return Le prochain joueur
	 */
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
	
	/**
	 * Méthode qui, pour une partie correctement initialisée, fait jouer les joueurs jusqu'à ce que la partie se termine.
	 */
	public void jouer()
	{
		Joueur joueurCourant = this.joueurs[0];
		boolean estTerminee = false;
		
		while (!estTerminee)
		{
			System.out.println("\n" + this.echiquierPartie);
			System.out.println("Au tour de " + joueurCourant + " jouer."); 
			
			// Si jouerTour renvoie false, alors le joueur courant est échec et mat.
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
