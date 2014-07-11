/**
 * Classe de test la plus importante puisque elle effectue des tests unitaires sur les méthodes de la classe Partie.
 * @author Ben Vittupier
 * @version 1.0
 */

package testPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.Echiquier;
import srcPackage.EnumCouleurs;
import srcPackage.Fou;
import srcPackage.Partie;
import srcPackage.Piece;
import srcPackage.Pion;
import srcPackage.Reine;
import srcPackage.Roi;
import srcPackage.Tour;

public class PartieTest
{
	/**
	 * Cette méthode teste si le déplacement d'un fou blanc est gêné par d'autres pièces de sa couleur.
	 */
	@Test
	public void testDeplacementNonGenePiecesMemeCouleurs()
	{
		Piece fou = new Fou(EnumCouleurs.BLANC);
		Piece pion = new Pion(EnumCouleurs.BLANC);
		
		Case caseDepart = new Case(2, 3, fou);
		Case caseInter1 = new Case(3, 4, fou);
		Case caseInter2 = new Case(4, 5, pion);
		Case caseArrivee = new Case(5, 6, null);
		
		Echiquier e = new Echiquier();
		e.setCase(caseDepart);
		e.setCase(caseInter1);
		e.setCase(caseInter2);
		e.setCase(caseArrivee);
		
		Partie p = new Partie(e);
		  
		assertFalse("If FB is at (2;3), he can't goes to (5;6) because there is FB at (3;4) and PB at (4;5)", p.deplacementNonGene(caseDepart, caseArrivee));
	}
	
	/**
	 * Cette méthode teste le déplacement d'un fou sur une case vide, avec toutes les cases intermédiaires vides.
	 */
	@Test
	public void testDeplacementNonGeneCasesAdjacentesVides()
	{
		Piece fou = new Fou(EnumCouleurs.BLANC);
		
		Case caseDepart = new Case(2, 3, fou);
		Case caseInter1 = new Case(3, 4, null);
		Case caseInter2 = new Case(4, 5, null);
		Case caseArrivee = new Case(5, 6, null);
		
		Echiquier e = new Echiquier();
		e.setCase(caseDepart);
		e.setCase(caseInter1);
		e.setCase(caseInter2);
		e.setCase(caseArrivee);
		
		Partie p = new Partie(e);

		assertTrue("If F is at (2;3), he can goes to (5;6) because (3;4) and (4;5) are empty", p.deplacementNonGene(caseDepart, caseInter2));
	}
	
	/**
	 * Cette méthode teste si un fou blanc peut se déplacer sur une case contenant un pion noir, avec toutes les cases intermédiaires vides.
	 */
	@Test
	public void testDeplacementNonGenePieceAdverseSurDestination()
	{
		Piece fou = new Fou(EnumCouleurs.BLANC);
		Piece pion = new Pion(EnumCouleurs.NOIR);
		
		Case caseDepart = new Case(2, 3, fou);
		Case caseInter1 = new Case(3, 4, null);
		Case caseInter2 = new Case(4, 5, null);
		Case caseArrivee = new Case(5, 6, pion);
		
		Echiquier e = new Echiquier();
		e.setCase(caseDepart);
		e.setCase(caseInter1);
		e.setCase(caseInter2);
		e.setCase(caseArrivee);
		
		Partie p = new Partie(e);

		assertTrue("If FB is at (2;3), he can goes to (5;6) because (3;4) and (4;5) are empty and (5;6) is other color.", p.deplacementNonGene(caseDepart, caseArrivee));
	}
	
	/**
	 * Cette méthode teste si un fou blanc peut se déplacer sur une case contenant un pion blanc, avec toutes les cases intermédiaires vides.
	 */
	@Test
	public void testDeplacementNonGenePieceAllieeSurDestination()
	{
		Piece fou = new Fou(EnumCouleurs.BLANC);
		Piece pion = new Pion(EnumCouleurs.BLANC);
		
		Case caseDepart = new Case(2, 3, fou);
		Case caseInter1 = new Case(3, 4, null);
		Case caseInter2 = new Case(4, 5, null);
		Case caseArrivee = new Case(5, 6, pion);

		Echiquier e = new Echiquier();
		e.setCase(caseDepart);
		e.setCase(caseInter1);
		e.setCase(caseInter2);
		e.setCase(caseArrivee);

		Partie p = new Partie(e);

		assertFalse("If FB is at (2;3), he can't goes to (5;6) because there is PB", p.deplacementNonGene(caseDepart, caseArrivee));
	}
	
	/**
	 * Cette fonction teste si un pion blanc peut prendre un pion adverse (doit renvoyer true) et un pion allié (doit renvoyer false).
	 */
	@Test
	public void testPionPeutPrendre()
	{
		Piece pionPrincipal = new Pion(EnumCouleurs.BLANC);
		Piece pionAllie = new Pion(EnumCouleurs.BLANC);
		Piece pionEnnemi = new Pion(EnumCouleurs.NOIR);
		
		Case casePionPrincipal = new Case(3, 4, pionPrincipal);
		Case casePionAllie = new Case(4, 3, pionAllie);
		Case casePionEnnemi = new Case(2, 3, pionEnnemi);
		
		Echiquier e = new Echiquier();
		e.setCase(casePionPrincipal);
		e.setCase(casePionAllie);
		e.setCase(casePionEnnemi);
		
		Partie p = new Partie(e);
		
		assertTrue("If PB is at (3;4), he can eat PN at (2;3)", p.pionPeutPrendre(casePionPrincipal, casePionEnnemi));
		assertFalse("If PB is at (3;4), he can't eat PB at (4;3)", p.pionPeutPrendre(casePionPrincipal, casePionAllie));
	}
	
	/**
	 * Cette fonction teste si le pion sélectionné peut avancer de deux cases (si c'est son premier déplacement) ou non.
	 */
	@Test
	public void testIsPremierDeplacementPion()
	{
		Piece pionBlanc = new Pion(EnumCouleurs.BLANC);
		Piece pionNoir = new Pion(EnumCouleurs.NOIR);
		
		Case goodBlanc = new Case(6, 1, pionBlanc);
		Case failBlanc = new Case(1, 5, pionBlanc);
		Case goodNoir = new Case(1, 1, pionNoir);
		Case failNoir = new Case(2, 1, pionNoir);
		
		Echiquier e = new Echiquier();
		e.setCase(goodBlanc);
		e.setCase(failBlanc);
		e.setCase(goodNoir);
		e.setCase(failNoir);
		
		Partie p = new Partie(e);
		
		assertTrue("If PB is at (1;6), it's his first play and he can moves by 2", p.isPremierDeplacementPion(goodBlanc));
		assertFalse("If PB is at (1;5), it's not his first play and he can't moves by 2", p.isPremierDeplacementPion(failBlanc));
		assertTrue("If PN is at (1;1), it's his first play and he can moves by 2", p.isPremierDeplacementPion(goodNoir));
		assertFalse("If PN is at (1;2), it's not his first play and he can't moves by 2", p.isPremierDeplacementPion(failNoir));
	}
	
	/**
	 * Cette méthode récupère les pièces adverses des blancs (les pièces noires) et vérifie qu'il y en a bien autant que dans le test.
	 */
	@Test
	public void testObtenirPositionsAdversaires()
	{
		EnumCouleurs couleurAllies = EnumCouleurs.BLANC;
		EnumCouleurs couleurEnnemis = EnumCouleurs.getOpposite(couleurAllies);
		
		Piece fou = new Fou(couleurEnnemis);
		Piece pion = new Pion(couleurEnnemis);
		Piece reine = new Reine(couleurEnnemis);
		
		Case caseFou = new Case(2, 3, fou);
		Case casePion = new Case(4, 5, pion);
		Case caseReine = new Case(3, 0, reine);
		
		Echiquier e = new Echiquier();
		e.setCase(caseFou);
		e.setCase(casePion);
		e.setCase(caseReine);
		
		Partie p = new Partie(e);
		ArrayList<Case> casesEnnemis = p.obtenirPositionPiecesAdverses(couleurAllies);
		
		assertTrue("ArrayList must have 3 elements", casesEnnemis.size() == 3);
		assertTrue("caseFou must be in ArrayList", casesEnnemis.contains(caseFou));
		assertTrue("casePion must be in ArrayList", casesEnnemis.contains(casePion));
		assertTrue("caseReine must be in ArrayList", casesEnnemis.contains(caseReine));
	}
	
	/**
	 * Cette fonction récupère la position du roi et vérifie qu'elle est bien identique à celle fixée dans le test.
	 */
	@Test
	public void testPositionRoi()
	{
		EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		Piece roi = new Roi(couleurRoi);
		Case caseRoi = new Case(2, 3, roi);
		
		Echiquier e = new Echiquier();
		e.setCase(caseRoi);
		
		Partie p = new Partie(e);
		
		assertTrue("r.getX() must be equals to 2", p.getPositionRoi(couleurRoi).getX() == 2);
		assertTrue("r.getY() must be equals to 3", p.getPositionRoi(couleurRoi).getY() == 3);
	}
	
	/**
	 * Teste si le roi noir est en échec à cause du fou blanc, sachant que toutes les cases intermédiaires sont vides.
	 */
	@Test
	public void testIsEchec()
	{
		EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		EnumCouleurs couleurEnnemis = EnumCouleurs.getOpposite(couleurRoi);
		
		Piece fou = new Fou(couleurEnnemis);
		Piece roi = new Roi(couleurRoi);
		
		Case caseDepart = new Case(2, 3, fou);
		Case caseInter1 = new Case(3, 4, null);
		Case caseInter2 = new Case(4, 5, null);
		Case caseArrivee = new Case(5, 6, roi);
		
		Echiquier e = new Echiquier();
		e.setCase(caseDepart);
		e.setCase(caseInter1);
		e.setCase(caseInter2);
		e.setCase(caseArrivee);
		
		Partie p = new Partie(e);
		
		assertTrue("If RN is at (5;6) and FB at (2;3), then R is in danger", p.isEchec(couleurRoi));
	}
	
	/**
	 * Teste, pour un roi noir seul et une combinaison de pièces blanches, si celui-ci est échec et mat.
	 */
	@Test
	public void testIsEchecEtmatRoiSeul()
	{
		 EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		 EnumCouleurs couleurEnnemis = EnumCouleurs.getOpposite(couleurRoi);
		  
		 Piece fou = new Fou(couleurEnnemis);
		 Piece reine = new Reine(couleurEnnemis);
		 Piece tour = new Tour(couleurEnnemis);
		 Piece tour2 = new Tour(couleurEnnemis);
		 Piece pion = new Pion(couleurEnnemis);
		 Piece roi = new Roi(couleurRoi);

		 Case caseFou = new Case(3, 5, fou);
		 Case caseReine = new Case(3, 2, reine);
		 Case caseTour = new Case(1, 0, tour);
		 Case caseTour2 = new Case(0, 6, tour2);
		 Case caseRoi = new Case(1, 3, roi);
		 Case casePion = new Case(2, 5, pion);

		 Echiquier e = new Echiquier();
		 e.setCase(caseFou);
		 e.setCase(caseReine);
		 e.setCase(caseTour);
		 e.setCase(caseTour2);
		 e.setCase(casePion);
		 e.setCase(caseRoi);
		  
		 Partie p = new Partie(e);

		 assertTrue("With FB at (4;2), DB at (2;1) and TB at (1;0) and (0;6), RN at (3;0) is dead", p.isEchecEtmat(couleurRoi));
	}
	
	/**
	 * Teste, pour un roi et un fou noirs et une combinaison de pièces blanches, si celui-ci est échec et mat.
	 */
	@Test
	public void testIsEchecEtmatRoiPlusPieces()
	{
		EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		EnumCouleurs couleurEnnemis = EnumCouleurs.getOpposite(couleurRoi);

		Piece fou = new Fou(couleurEnnemis);
		Piece reine = new Reine(couleurEnnemis);
		Piece tour = new Tour(couleurEnnemis);
		Piece tour2 = new Tour(couleurEnnemis);
		Piece pion = new Pion(couleurEnnemis);
		Piece roi = new Roi(couleurRoi);
		Piece fou2 = new Fou(couleurRoi);

		Case caseFou = new Case(3, 5, fou);
		Case caseReine = new Case(3, 2, reine);
		Case caseTour = new Case(1, 0, tour);
	  	Case caseTour2 = new Case(0, 6, tour2);
	  	Case caseRoi = new Case(1, 3, roi);
	  	Case casePion = new Case(2, 5, pion);
	  	Case caseFou2 = new Case(2, 4, fou2); 
	   
	  	Echiquier e = new Echiquier();
	  	e.setCase(caseFou);
	  	e.setCase(caseReine);
	  	e.setCase(caseTour);
	  	e.setCase(caseTour2);
	  	e.setCase(casePion);
	  	e.setCase(caseRoi);
	  	e.setCase(caseFou2);
	   
	  	Partie p = new Partie(e);

	  	assertTrue("With FB at (3;5), DB at (3;2), TB at (1;0) and (0;6) and PB at (2;5) and even with FN at (2;4), RN at (3;0) is dead", p.isEchecEtmat(couleurRoi));
	}
	
	/**
	 * Teste, pour un roi et deux fous noirs et une combinaison de pièces blanches, si celui-ci est échec et mat.
	 */
	@Test
	public void testIsEchecEtmatRoiPlusPlusPieces()
	{
		EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		EnumCouleurs couleurEnnemis = EnumCouleurs.getOpposite(couleurRoi);

		Piece fou = new Fou(couleurEnnemis);
		Piece reine = new Reine(couleurEnnemis);
		Piece tour = new Tour(couleurEnnemis);
		Piece tour2 = new Tour(couleurEnnemis);
		Piece pion = new Pion(couleurEnnemis);
		Piece roi = new Roi(couleurRoi);
		Piece fou2 = new Fou(couleurRoi);
		Piece fou3 = new Fou(couleurRoi);

		Case caseFou = new Case(3, 5, fou);
		Case caseReine = new Case(3, 2, reine);
		Case caseTour = new Case(1, 0, tour);
	    Case caseTour2 = new Case(0, 6, tour2);
	    Case caseRoi = new Case(1, 3, roi);
	    Case casePion = new Case(2, 5, pion);
	    Case caseFou2 = new Case(2, 4, fou2); 
	    Case caseFou3 = new Case(2, 2, fou3);

	    Echiquier e = new Echiquier();
	    e.setCase(caseFou);
	    e.setCase(caseReine);
	    e.setCase(caseTour);
	    e.setCase(caseTour2);
	    e.setCase(casePion);
	    e.setCase(caseRoi);
	    e.setCase(caseFou2);
	    e.setCase(caseFou3);
	  
	    Partie p = new Partie(e);

	    assertTrue("With FB at (3;5), DB at (3;2), TB at (1;0) and (0;6) and PB at (2;5) and even with FN at (2;4) and (2;2), RN at (3;0) is dead", p.isEchecEtmat(couleurRoi));
	}
	
	/**
	 * Teste, pour un roi seul dans un coin de l'échiquier une combinaison de pièces blanches, si celui-ci est échec et mat.
	 */
	@Test
	public void testIsEchecEtmatRoiCoinEchiquier()
	{
		EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		EnumCouleurs couleurEnnemis = EnumCouleurs.getOpposite(couleurRoi);
		
		Piece fou = new Fou(couleurEnnemis);
		Piece reine = new Reine(couleurEnnemis);
		Piece tour = new Tour(couleurEnnemis);
		Piece roi = new Roi(couleurRoi);
		
		Case caseFou = new Case(2, 2, fou);
		Case caseReine = new Case(2, 0, reine);
		Case caseTour = new Case(0, 2, tour);
		Case caseRoi = new Case(0, 0, roi);
		
		Echiquier e = new Echiquier();
		e.setCase(caseFou);
	    e.setCase(caseReine);
	    e.setCase(caseTour);
	    e.setCase(caseRoi);
	    
	    Partie p = new Partie(e);

	    assertTrue("With FB at (2;2), DB at (2;0) and TB at (0;2), RN at (0;0) is dead", p.isEchecEtmat(couleurRoi));
	}
	
	/**
	 * Teste que la position des pièces au départ du jeu ne mette aucun roi en échec et mat.
	 */
	@Test
	public void testIsEchecEtMatJeuDepart()
	{
		EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		
		Echiquier e = new Echiquier();
		e.initialiserEchiquier();
		
		Partie p = new Partie(e);
		assertFalse("With start game, RN can't be dead", p.isEchecEtmat(couleurRoi));
	}
	
	/**
	 * Teste que la position des pièces au départ (avec un pion adverse ayant bougé) ne mette aucun roi en échec et mat.
	 */
	@Test
	public void testIsEchecEtMatJeuDepartMouvementPionBlanc()
	{
		EnumCouleurs couleurRoi = EnumCouleurs.NOIR;
		
		Echiquier e = new Echiquier();
		e.initialiserEchiquier();
		
		Piece c = e.getCase(6, 1).getPiece();
		e.setCase(new Case(6, 1, null));
		e.setCase(new Case(5, 1, c));
		
		Partie p = new Partie(e);
		assertFalse("With start game and PB at (5;1), RN can't be dead", p.isEchecEtmat(couleurRoi));
	}
}
