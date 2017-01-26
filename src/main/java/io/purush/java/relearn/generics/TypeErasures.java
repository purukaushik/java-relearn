package io.purush.java.relearn.generics;

public class TypeErasures {
  public static void main(String[] args){
    NO no = new NO(5);
    NN n = no;
    // Compile error  due to type erasure
    // Integer x = n.t;
  }
  
}
          /*(1) just T */
class Node<T extends Comparable<T>> { /*(2)*/
  private T data; // (1) replaced with Object -> unbounded generic
                  // (2) replaced with Comparable -> bounded generic
  private Node<T> next;

  public Node(T data, Node<T> next){
    this.data = data;
    this.next = next;
  }
  
  public T getData() { return data;}
}

class NN<T>{
  public T t;
  public NN(T data){ t=data;}
}
class NO extends NN<Integer>{
  public NO(Integer data){super(data);}
}













