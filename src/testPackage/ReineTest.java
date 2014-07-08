package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.EnumCouleurs;
import srcPackage.Piece;
import srcPackage.Reine;

public class ReineTest
{
	@Test
	public void testDeplacementPossible()
	{
		Piece reine = new Reine(EnumCouleurs.BLANC);
		Case caseDepart = new Case(4, 3, reine);
		
		assertTrue("If D is on (4;3), she can goes to (0;7)", reine.deplacementPossible(caseDepart, new Case(0, 7)));
		assertTrue("If D is on (4;3), she can goes to (4;0)", reine.deplacementPossible(caseDepart, new Case(4, 0)));
		assertTrue("If D is on (4;3), she can goes to (4;4)", reine.deplacementPossible(caseDepart, new Case(4, 4)));
		assertFalse("If D is on (4;3), she can't goes to (0;0)", reine.deplacementPossible(caseDepart, new Case(0, 0)));
	}

}
