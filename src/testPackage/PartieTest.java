package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.Echiquier;
import srcPackage.EnumCouleurs;
import srcPackage.Fou;
import srcPackage.Partie;
import srcPackage.Piece;
import srcPackage.Pion;

public class PartieTest
{
	@Test
	public void testDeplacementNonGeneFalse()
	{
		Piece fou = new Fou(EnumCouleurs.BLANC);
		Piece pion = new Pion(EnumCouleurs.BLANC);
		Case caseDepart = new Case(2, 3, fou);
		Case caseInter1 = new Case(3, 4, fou);
		Case caseInter2 = new Case(4, 5, pion);
		Case caseArrivee = new Case(5, 6, null);
		Partie p = new Partie();
		  
		assertFalse("If F is at (2;7), he can goes to (0;5)", p.deplacementNonGene(caseDepart, caseArrivee));
	}
	
	@Test
	public void testDeplacementNonGeneTrue()
	{
		Piece fou = new Fou(EnumCouleurs.BLANC);
		Case caseDepart = new Case(2, 3, fou);
		Case caseInter1 = new Case(3, 4, null);
		Case caseInter2 = new Case(4, 5, null);
		Case caseArrivee = new Case(5, 6, null);
		Partie p = new Partie();

		assertTrue("If F is at (2;7), he can goes to (0;5)", p.deplacementNonGene(caseDepart, caseInter2));
	}
}
