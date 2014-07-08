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
		CaseTest.class
	}
)
public class AllTests
{
	public static void main(String[] args)
	{
		List<Class<?>> classes = new ArrayList<Class<?>>();
		
		classes.add(EnumCouleursTest.class);
		classes.add(CaseTest.class);
		
		for (Class<?> testClass : classes)
		{
			runTestCase(testClass);
		}
	}
	
	private static void runTestCase(Class<?> testClass)
    {
        Result result = JUnitCore.runClasses(testClass);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
    }
} 
