package io.purush.java.relearn.interfaces.conflictingDefaults;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class InterfaceImplTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InterfaceImplTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InterfaceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDay()
    {
      InterfaceImpl defMethIfaceImpl = new InterfaceImpl();
      defMethIfaceImpl.call();
    }
}
