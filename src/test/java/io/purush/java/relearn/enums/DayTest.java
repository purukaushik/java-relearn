package io.purush.java.relearn.enums;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DayTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DayTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DayTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDay()
    {
      Day day = Day.WEDNESDAY;
      assertEquals(day.toString(), Day.WEDNESDAY.toString() );
    }
}
