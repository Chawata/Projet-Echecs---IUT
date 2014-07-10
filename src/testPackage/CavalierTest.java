package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.Cavalier;
import srcPackage.EnumCouleurs;
import srcPackage.Piece;
import srcPackage.Roi;

public class CavalierTest
{
	@Test
	public void testDeplacementPossible()
	{
		Piece cavalier = new Cavalier(EnumCouleurs.BLANC);
		Case caseDepart = new Case(1, 7, cavalier);
		
		assertTrue("If C is at (1;7), he can moves to (0;6)", cavalier.deplacementPossible(caseDepart, new Case(0, 5)));
		assertTrue("If C is at (1;7), he can moves to (2;6)", cavalier.deplacementPossible(caseDepart, new Case(2, 5)));
		assertFalse("If C is at (1;7), he can't move to (4;7)", cavalier.deplacementPossible(caseDepart, new Case(4, 7)));
		
		caseDepart = new Case(3, 4, cavalier);
		assertTrue("If C is at (3;4), he can moves to (4;2)", cavalier.deplacementPossible(caseDepart, new Case(4, 2)));
		assertTrue("If C is at (3;4), he can moves to (2;6)", cavalier.deplacementPossible(caseDepart, new Case(2, 6)));
		assertFalse("If C is at (3;4), he can't move to (4;7)", cavalier.deplacementPossible(caseDepart, new Case(4, 7)));
		
		caseDepart = new Case(2, 5, cavalier);
		assertTrue("If C is at (2;5), he can moves to (0;4)", cavalier.deplacementPossible(caseDepart, new Case(0, 4, new Roi(EnumCouleurs.NOIR))));
	}
}
