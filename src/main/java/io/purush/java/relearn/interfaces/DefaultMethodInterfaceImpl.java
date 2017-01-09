package io.purush.java.relearn.interfaces;

/**
 * A class that implements a default method interface. Here the overridden method will be called over the interface method.
 */
public class DefaultMethodInterfaceImpl implements DefaultMethodInterface{
  public void performanceKudunga(){
    System.out.println("Implemented performanceKudunga");
  }
  public void perform(){
    System.out.println("Implemented perform");
  }
}
