package io.purush.java.relearn.interfaces.exercises;

public class MainClient {
  public static void main(String []args) {
    
    String testString = "Questions and Exercises: Interfaces";
    char[] charSeq = testString.toCharArray();
    
    ReverseCharSeq reverse1 = new ReverseCharSeq(charSeq);
    ReverseCharSeq reverse2 = new ReverseCharSeq(reverse1.toString().toCharArray());

    println("Original --> " + testString);
    println("Reverse --> " + reverse1.toString());
    println("Reverse of Reverse --> " + reverse2.toString());
    
    println("Subsequence(3,7 --> )" + reverse1.subSequence(3,7));
  }

  private static void println(Object object){
    System.out.println(object.toString());
  }

}
