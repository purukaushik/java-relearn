package io.purush.java.relearn.collections.aggregations;
import java.util.*;
public class Parallelism {
  public static void main(String[] args){
    // this parallel stream processing does not return same results as non parallel stream operation
        String toReduce = "Lambda calculus (also written as λ-calculus) is a formal system in mathematical logic for expressing computation based on function abstraction and application using variable binding and substitution. It is a universal model of computation that can be used to simulate any single-taped Turing machine and was first introduced by mathematician Alonzo Church in the 1930s as part of an investigation into the foundations of mathematics.";
	Arrays.stream(toReduce.split("\\s+")).parallel().reduce("", (a,x)-> a + "\t"+ x);

  }
}
