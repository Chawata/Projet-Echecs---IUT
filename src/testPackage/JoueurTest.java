package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Case;
import srcPackage.Joueur;

public class JoueurTest
{
	@Test
	public void testCreationJoueur()
	{
		Joueur j = new Joueur("Chuck Norris");
		assertEquals("The player name is Chuck Norris", "Chuck Norris", j.getNom());
	}
	
	@Test
	public void testInput()
	{
		Joueur j = new Joueur("Chuck Norris");
		Case testCase = j.saisirCaseArrivee();
		
		System.out.println("Is input valid ? x = " + testCase.getX() + " y = " + testCase.getY());
	}
}
