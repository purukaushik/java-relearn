package io.purush.java.relearn.interfaces;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DefaultMethodInterfaceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DefaultMethodInterfaceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DefaultMethodInterfaceTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDay()
    {
      
      DefaultMethodInterface defMethIface = ()->{
	  System.out.println("Performance from anonymous object.");
      };
      defMethIface.perform();
      defMethIface.performanceKudunga();
    }
}
