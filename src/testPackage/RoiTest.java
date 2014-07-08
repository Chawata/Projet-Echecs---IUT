package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.EnumCouleurs;
import srcPackage.Piece;
import srcPackage.Roi;

public class RoiTest
{
	@Test
	public void testDeplacementPossible()
	{
		Piece roi = new Roi(EnumCouleurs.BLANC);
		Case caseDepart = new Case(4, 4, roi);
		
		assertTrue("If R is at (4;4), he can goes to (3;3)", roi.deplacementPossible(caseDepart, new Case(3, 3)));
		assertTrue("If R is at (4;4), he can goes to (4;3)", roi.deplacementPossible(caseDepart, new Case(4, 3)));
		assertTrue("If R is at (4;4), he can goes to (5;4)", roi.deplacementPossible(caseDepart, new Case(5, 4)));
		assertFalse("If R is at (4;4), he can't goes to (0;0)", roi.deplacementPossible(caseDepart, new Case(0, 0)));
		assertFalse("If R is at (4;4), he can't goes to (4;2)", roi.deplacementPossible(caseDepart, new Case(4, 2)));
	}

}
