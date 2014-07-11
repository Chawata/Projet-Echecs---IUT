package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.Joueur;

public class JoueurTest
{
	@Test
	public void testCreationJoueur()
	{
		Joueur j = new Joueur("Chuck Norris");
		assertEquals("The player name is Chuck Norris", "Chuck Norris", j.getNom());
	}
}
