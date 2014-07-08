package testPackage;

import srcPackage.EnumCouleurs;
import static org.junit.Assert.*;
import org.junit.Test;

public class EnumCouleursTest
{
	@Test
	public void testEquality()
	{
		EnumCouleurs e1 = EnumCouleurs.BLANC;
		EnumCouleurs e2 = EnumCouleurs.NOIR;
		EnumCouleurs e3 = EnumCouleurs.BLANC;
		
		assertTrue("EnumCouleurs.BLANC must be equals to EnumCouleurs.BLANC", e1 == e3);
		assertTrue("EnumCouleurs.BLANC must be different of EnumCouleurs.NOIRC", e1 != e2);
	}

}
