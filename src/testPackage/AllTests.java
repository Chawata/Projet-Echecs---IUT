/**
 * Regroupement de tous les tests unitaires pour tous les exécuter en même temps.
 * @author Ben Vittupier
 * @version 1.0
 */

package testPackage;

import java.util.List;
import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Suite.class)
@SuiteClasses
(
	{
		EnumCouleursTest.class,
		CaseTest.class,
		CavalierTest.class,
		FouTest.class,
		PionTest.class,
		ReineTest.class,
		RoiTest.class,
		TourTest.class,
		JoueurTest.class,
	}
)
public class AllTests
{
	/**
	 * Cette méthode va, pour chaque classe qu'on lui donne, lancer tous ses tests.
	 * @param args Arguments optionnels pouvant être donnés en ligne de commande.
	 */
	public static void main(String[] args)
	{
		List<Class<?>> classes = new ArrayList<Class<?>>();
		
		classes.add(EnumCouleursTest.class);
		classes.add(CaseTest.class);
		classes.add(CavalierTest.class);
		classes.add(FouTest.class);
		classes.add(PionTest.class);
		classes.add(ReineTest.class);
		classes.add(RoiTest.class);
		classes.add(TourTest.class);
		classes.add(JoueurTest.class);
		
		for (Class<?> testClass : classes)
		{
			runTestCase(testClass);
		}
	}
	
	/**
	 * Cette méthode lance les tests d'une classe et affiche les éventuelles erreurs.
	 * @param testClass La classe dont on veut lancer les tests.
	 */
	private static void runTestCase(Class<?> testClass)
    {
        Result result = JUnitCore.runClasses(testClass);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
    }
} 
