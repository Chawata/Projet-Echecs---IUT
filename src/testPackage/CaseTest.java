package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.EnumCouleurs;
import srcPackage.Pion;
import srcPackage.Reine;
import srcPackage.Roi;

public class CaseTest
{
	@Test
	public void testCreation()
	{
		Case c = new Case(0, 0);

		assertTrue("In this exemple, x must be 0", c.getX() == 0);
		assertTrue("In this exemple, y must be 0", c.getY() == 0);
	}
	
	@Test
	public void testSetters()
	{
		Case c = new Case(0, 0);
		c.setX(4);
		c.setY(7);
		
		assertTrue("In this exemple, x is now 4", c.getX() == 4);
		assertTrue("In this exemple, y is now 7", c.getY() == 7);
	}

	@Test
	public void testGetPiece()
	{
		Case c1 = new Case(0, 0);
		assertTrue("In this exemple, getPiece() must be null", c1.getPiece() == null);
		
		Case c2 = new Case(0, 0, new Pion(EnumCouleurs.BLANC));
		assertTrue("In this exemple, getPiece() is not null", c2.getPiece() != null);
	}
	
	@Test
	public void testSetPiece()
	{
		Case c = new Case(0, 0, new Pion(EnumCouleurs.BLANC));
		c.setPiece(new Reine(EnumCouleurs.NOIR));
		
		assertTrue("In this exemple, there is now a Lady", c.getPiece() instanceof Reine);
	}
	
	@Test
	public void testCaseOccupee()
	{
		Case c = new Case(0, 0);
		
		assertTrue("In this exemple, case (0,0) is empty", !c.caseOccupee());
		c.setPiece(new Roi(EnumCouleurs.BLANC));
		assertTrue("In this exemple, case (0,0) has a king now", c.caseOccupee());
	}
}
