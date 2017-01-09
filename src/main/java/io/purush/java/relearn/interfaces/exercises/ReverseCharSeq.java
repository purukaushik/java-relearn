package io.purush.java.relearn.interfaces.exercises;
import java.lang.CharSequence;

/**
 * Reversed string implementing the {@link java.lang.CharSequence} interface.
 * This class is immutable like {@link java.lang.String}.
 * @author Purush Swaminathan
*/
public class ReverseCharSeq implements CharSequence{

  // Store the reversed string
  private final char[] reverseCharSeq;
  
  // original string for some random purposes
  private final char[] original;

  // keeping length for simplifying things
  private final int length;
  
  /**
   *@param reverseThis to be reversed
   */
  public ReverseCharSeq(char [] reverseThis){
    length = reverseThis.length;
    reverseCharSeq = new char[length];
    original = new char[length];
    
    for(int i=0; i<length; i++){
      reverseCharSeq[i] = reverseThis[length-1-i];
      original[i] = reverseThis[i];
    }
  }

  /**
   *@return the length of the reversed string.
   */
  public int length(){
    return length;
  }

  /**
   * Get character at a particular position.
   * @param index at which character is requested
   */
  public char charAt(int index){
    if(index<0 || index>=length) throw new StringIndexOutOfBoundsException(""+index);
    return reverseCharSeq[index];
  }

  /**
   * Returns the subSequence from start to end(exlusive) indexes. The string  is 
   the reverse of what was sent in to the constructor.
   *@param start
   *@param end
   *@return reversed string subSequence
   */
  public CharSequence subSequence(int start, int end){
    if(start < 0){
      throw new StringIndexOutOfBoundsException(start+"");
    }
    if(end<start){
      throw new StringIndexOutOfBoundsException((start-end) + "");
    }
    if(end>=length){
      throw new StringIndexOutOfBoundsException(end+"");
    }
    char[] subSequence = new char[end-start-1];
    for(int i=0; i<subSequence.length;i++){
      subSequence[i] = reverseCharSeq[start+i];
    }
    return new String(subSequence);
  }

  
  public String toString(){
    return new String(reverseCharSeq);
  }

  public String original(){
    return new String(original);
  }
  
}
