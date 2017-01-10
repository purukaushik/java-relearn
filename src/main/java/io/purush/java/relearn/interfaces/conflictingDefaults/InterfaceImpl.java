package io.purush.java.relearn.interfaces.conflictingDefaults;

public class InterfaceImpl implements Interface1
/* --> UNCOMMENTING WILL CAUSE COMPILE ERROR <-- Interface2 */   {
  public void call(){
    System.out.println("Interface Impl");
    method();
  }
}
