package io.purush.java.relearn.lambda;

import java.util.stream.IntStream;
import java.util.Iterator;
import java.math.BigInteger;
import java.util.stream.StreamSupport;
import java.util.stream.Stream;

public class StreamingExample {
  public static void main(String[] args){
    
    //iteratorized
    // for(BigInteger fib: new FibanocciIterator(50)){
    //   System.out.println(fib.toString());
    // }
    //streamed
    System.out.println(FibanocciStream.stream().reduce( (a,x) -> a.add(x)));
    
  }
}
/**
 * A helper that generates fibanocci streams. All fibanocci numbers are BigIntegers.
 */
class FibanocciStream {
  /**
   * A Default stream of 1024 Big Fibanocci Integers
   */
  public static Stream<BigInteger> stream(){
    return StreamSupport.stream(new FibanocciIterator().spliterator(), false);
  }
  /**
   * A limited stream of Big Fibanocci Integers. You provide the limit.
   */
  public static Stream<BigInteger> stream(int limit){
    return StreamSupport.stream(new FibanocciIterator(limit).spliterator(), false);
  }
}
class FibanocciGenerator {

  private BigInteger f1, f2;

  public FibanocciGenerator(){
    f1 = BigInteger.ZERO;
    f2 = BigInteger.ONE;
  }

  public FibanocciGenerator(long f1, long f2){
    this.f1 = BigInteger.valueOf(f1);
    this.f2 = BigInteger.valueOf(f2);
  }
  public FibanocciGenerator(BigInteger f1, BigInteger f2){
    // BigIntegers are immutable, so this is fair
    this.f1 = f1;
    this.f2 = f2;
  }
  protected BigInteger nextFib(){
    BigInteger f3 = f1.add(f2);
    f1 = f2;
    f2 = f3;
    return f3;
  }  
}
// Idea to stream out fibanoci numbers using IntSupplier, IntStream
class FibanocciIterator extends FibanocciGenerator implements Iterator<BigInteger>, Iterable<BigInteger> {
  private int limit;
  private int count;
  public FibanocciIterator(){
    this.limit = 1024;
  }

  public FibanocciIterator(int limit){
    super();
    this.limit  = limit;
  }

  public FibanocciIterator(long f1, long f2, int limit){
    super(f1,f2);
    this.limit = limit;
  }
  public FibanocciIterator(BigInteger f1, BigInteger f2, int limit){
    super(f1,f2);
    this.limit= limit;
  }
  
  @Override
  public BigInteger next(){
    count++;
    return nextFib();
  }
  
  @Override
  public boolean hasNext(){
    return count < limit;
  }

  @Override
  public Iterator<BigInteger> iterator(){
    return this;
  }
}
