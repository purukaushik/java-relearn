package io.purush.java.relearn.collections.aggregations;

import java.util.stream.IntStream;
import java.util.function.IntConsumer;
import java.util.Arrays;

public class Streams{
  public static void main(String[] args){
    // creating int streams
    IntStream ofStream = IntStream.of(1,2,3);
    IntStream openRangeIntStream = IntStream.range(1,500);
    IntStream closedRangeIntStream = IntStream.rangeClosed(-500,400);

    // operations on streams
    double average = openRangeIntStream
      .filter( x -> x%2==0)
      .average().getAsDouble();
    
    // Empty stream and OptionalDouble averages
    IntStream.empty().average(); // => OptionalDouble.empty

    // using collect with IntConsumer
    average = closedRangeIntStream.collect(IntCombiner::new, IntCombiner::accept, IntCombiner::combine).average();
    System.out.println("Resulted in -> " + average);

    // collect(supplier, accumulator, combiner)
    // supplier -> new container for results
    // accumulator -> apply an element from stream into a fn and move it to the container
    // combiner -> combines result of accumulator with supplier


    // stream.reduce() to join strings
    String toReduce = "Lambda calculus (also written as λ-calculus) is a formal system in mathematical logic for expressing computation based on function abstraction and application using variable binding and substitution. It is a universal model of computation that can be used to simulate any single-taped Turing machine and was first introduced by mathematician Alonzo Church in the 1930s as part of an investigation into the foundations of mathematics.";
    Arrays.stream(toReduce.split("\\s+")).reduce("", (a,x)-> a + "\t"+ x);
    
  }
}
class IntCombiner implements IntConsumer {
  private int total = 0;
  private int count = 0;

  public void accept(int value){
    total+=value;
    count++;
  }
  public double average(){
    return count >0 ? ((double) total)/count : 0;
  }
  public void combine(IntCombiner other){
    total+=other.total;
    count+=other.count;
  }
}
