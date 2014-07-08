package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.EnumCouleurs;
import srcPackage.Piece;
import srcPackage.Pion;

public class PionTest
{
	@Test
	public void testDeplacementPossible()
	{
		Piece pion = new Pion(EnumCouleurs.BLANC);
		Case caseDepart = new Case(0, 6, pion);
		
		assertTrue("If P is at (0;6), he can goes to (0;5)", pion.deplacementPossible(caseDepart, new Case(0, 5)));
		assertFalse("If P is at (0;6), he can't goes to (0;4)", pion.deplacementPossible(caseDepart, new Case(0, 4)));
		assertFalse("If P is at (0;6), he can't goes to (1;5)", pion.deplacementPossible(caseDepart, new Case(1, 5)));
	}

}
