package io.purush.java.relearn.interfaces;

/**
 * Extending the first interface {@link ExtensibleInterface} to add a new method 
 that downstream classes can implement optionally in addition to stuff in {@link ExtensibleInterface}.
*/
public interface ExtendedInterface extends ExtensibleInterface{
  void performanceKudunga();
}

