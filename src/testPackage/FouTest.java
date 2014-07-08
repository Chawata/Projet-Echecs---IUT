package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.EnumCouleurs;
import srcPackage.Fou;
import srcPackage.Piece;

public class FouTest
{
	@Test
	public void testDeplacementPossible()
	{
		Piece fou = new Fou(EnumCouleurs.BLANC);
		Case caseDepart = new Case(2, 7, fou);
		
		assertTrue("If F is at (2;7), he can goes to (0;5)", fou.deplacementPossible(caseDepart, new Case(0, 5)));
		assertTrue("If F is at (2;7), he can goes to (7;2)", fou.deplacementPossible(caseDepart, new Case(7, 2)));
		assertFalse("If F is at (2;7), he can't goes to (0;0)", fou.deplacementPossible(caseDepart, new Case(0, 0)));
		
		caseDepart = new Case(4, 3, fou);
		assertTrue("If F is at (4;3), he can goes to (0;7)", fou.deplacementPossible(caseDepart, new Case(0, 7)));
		assertTrue("If F is at (4;3), he can goes to (7;6)", fou.deplacementPossible(caseDepart, new Case(7, 6)));
		assertFalse("If F is at (4;3), he can't goes to (0;5)", fou.deplacementPossible(caseDepart, new Case(0, 5)));
	}

}
