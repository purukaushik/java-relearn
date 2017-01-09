package io.purush.java.relearn.interfaces;

/**
 * A Java 8 Defaul method interface. The `default` method replaces the need for 
an extended interface to add additional methods to an existing interface 
without breaking downstream impl classes. The `default` method may or may not be overridden downstream.
 */
public interface DefaultMethodInterface{
  void performanceKudunga();
  default void perform(){
    System.out.println("Default performance");
  }
}
