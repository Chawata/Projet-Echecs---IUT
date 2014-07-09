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
	
	@Test
	public void testIsPremierDeplacementPion()
	{
		Piece pionBlanc = new Pion(EnumCouleurs.BLANC);
		Piece pionNoir = new Pion(EnumCouleurs.NOIR);
		
		Case goodBlanc = new Case(1, 6, pionBlanc);
		Case failBlanc = new Case(1, 5, pionBlanc);
		Case goodNoir = new Case(1, 1, pionNoir);
		Case failNoir = new Case(1, 2, pionNoir);
		
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

	  	assertTrue("With FB at (4;2), DB at (2;1) and TB at (1;0) and (0;6), RN at (3;0) is dead", p.isEchecEtmat(couleurRoi));
	}
}
