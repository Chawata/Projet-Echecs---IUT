package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.EnumCouleurs;
import srcPackage.Piece;
import srcPackage.Tour;

public class TourTest
{
	@Test
	public void testDeplacementPossible()
	{
		Piece tour = new Tour(EnumCouleurs.BLANC);
		Case caseDepart = new Case(7, 7, tour);
		
		assertTrue("If T is at (7;7), she can goes to (7;0)", tour.deplacementPossible(caseDepart, new Case(7, 0)));
		assertTrue("If T is at (7;7), she can goes to (0;7)", tour.deplacementPossible(caseDepart, new Case(0, 7)));
		assertFalse("If T is at (7;7), she can't goes to (0;0)", tour.deplacementPossible(caseDepart, new Case(0, 0)));
	}

}
