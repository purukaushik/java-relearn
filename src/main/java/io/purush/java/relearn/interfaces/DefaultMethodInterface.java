package io.purush.java.relearn.interfaces;

public interface DefaultMethodInterface{
  void performanceKudunga();
  default void perform(){
    System.out.println("Default performance");
  }
}
