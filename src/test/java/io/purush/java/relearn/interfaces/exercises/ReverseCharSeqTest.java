package io.purush.java.relearn.interfaces.exercises;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ReverseCharSeqTest 
  extends TestCase
{
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public ReverseCharSeqTest( String testName )
  {
    super( testName );
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
    return new TestSuite( ReverseCharSeqTest.class );
  }

  
  public void testReverseCharSeq(){
    char[] charSeq = "Questions and Exercises: Interfaces".toCharArray();
    ReverseCharSeq r1 = new ReverseCharSeq(charSeq);

    println("Asserting lengths...");
    assertEquals(r1.length(), charSeq.length);

    println("Asserting original charSeq and ReverseCharSeq.original() ...");
    assertEquals(r1.original(), new String(charSeq));
    
    ReverseCharSeq r2 = new ReverseCharSeq(r1.toString().toCharArray());
    
    println("Asserting ReverseCharSeq.toString ...");
    assertEquals(r2.toString(), new String(charSeq));

    CharSequence subsequence = r1.subSequence(3,7);
    println("Asserting subsequence of ReverseCharSeq ...");
    assertEquals(subsequence.toString(), "afr");

    println("Asserting ReverseCharSeq.charAt...");
    assertEquals(r1.charAt(4), 'f');
      
  }

  public void testOutOfBounds(){
    char[] charSeq = "Questions and Exercises: Interfaces".toCharArray();
    ReverseCharSeq r1 = new ReverseCharSeq(charSeq);
    try{
      r1.subSequence(-1,0);
    }catch(StringIndexOutOfBoundsException stringIOBE){
      assertTrue(true);
    }

    try{
      r1.subSequence(1,0);
    }catch(StringIndexOutOfBoundsException stringIOBE){
      assertTrue(true);
    }

    try{
      r1.subSequence(0,1000);
    }catch(StringIndexOutOfBoundsException stringIOBE){
      assertTrue(true);
    }

  }
  
  private static void println(Object object){
    System.out.println(object.toString());
  }
}
