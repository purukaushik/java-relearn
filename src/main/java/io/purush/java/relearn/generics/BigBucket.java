package io.purush.java.relearn.generics;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Arrays;

public class BigBucket{
  // Many generic based examples here
  public static void main(String[] args){
    //Generic generic
    Tuple2<Integer,Integer> tuple2 = new Tuple2<>(2,3);
    System.out.println(Util.compare(tuple2, new Tuple2<Integer,Integer>(2,3)));
    // bounded generic  -- valid one
    NumberedTuple2<Integer, Integer> numberTuple2 = new NumberedTuple2<>(3,6);
    // bounded generic -- invalid one
    // NumberedTuple2<String, String> stringifiedTuple2 = new NumberedTuple2<>("2", "3");
    Tuple2<String, Character> anOddTuple = new Tuple2<>("String", 's');
    System.out.println(Util.compare(anOddTuple, new Tuple2<>("String", (char)115)));
    //compare across generics...will it work??
    Tuple2<String, Integer> mapPair = new Tuple2<>("2", 3);
    // Wont work -> inferred type does not conform to equality constraints
    //System.out.println(Util.compare(mapPair, anOddTuple));
    
    // generics and subtyping
    // valid parameterizations of List<String>
    // TupledList<String, String>
    // TupledList<String,Integer>
    // TupledList<String,Exception>...etc

    // Type Witnesses
    List<String> listOne = Collections.<String>emptyList();

    // Wildcards
    // Upper bounded wildcards
    // this is totally useless separately  -- > List<? extends Number> list = new ArrayList<>();
    // Unbounded wildcards
    // Goal -> print list items of any type
    List<Integer> li = Arrays.asList(1,2,3);
    List<String> ls = Arrays.asList("1_", "2_");
    printlnList(li);
    printlnList(ls);
    List<Number> xs = new ArrayList<>();
    do__(xs);
  }
  //1. List<Object> Println This wont work for List<Anything> though
  /*static void printlnList(List<Object> listO){
    for(Object elem: listO){
      System.out.print(elem + " ");
    }
    System.out.println();
    }*/

  //2. List<?> Println
  static void printlnList(List<?> list){
    for(Object elem : list){
      System.out.print(elem + " ");
    }
    System.out.println();
  }
  
  static void do__(List<? super Integer> xs){
    
  }
}

interface ITuple2<K,V> {
  public K _1();
  public V _2();
}
class NumberedTuple2<K extends Number, V extends Number> implements ITuple2<K,V>{
  private final K k;
  private final V v;
  
  public NumberedTuple2(K k, V v){
    this.k = k;
    this.v = v;
  }
  public K _1(){return this.k;}
  public V _2(){return this.v;}
}
class Tuple2<K,V> implements ITuple2<K,V>{

  private final K k; private final V v;

  public Tuple2(K k, V v){
    this.k = k;
    this.v = v;
  }
  @Override
  public K _1(){
    return k;
  }
  @Override
  public V _2(){
    return v;
  }
}
class Util {
  public static <K,V> boolean compare(ITuple2<K,V> p1, ITuple2<K,V> p2){
    return p1._1().equals(p2._1()) && p1._2().equals(p2._2());
  }
}

/* Generics and subtyping*/

interface TupledList<E,P> extends List<E>{
  void setTuple2(int index, P val);
}
class ExtTupledList<E,P>  extends ArrayList<E> implements TupledList<E,P>{
  @Override
  public void setTuple2(int index, P val){
    // do something...
  }
}


