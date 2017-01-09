package io.purush.java.relearn.interfaces;

interface StaticDefaultMethodInterface{

default void print(String something){
  System.out.println("StaticDefaultMethodInterface::print");
  if(!isNull(something)){
  System.out.println(something + " is the something");    
  }

}
  static boolean isNull(String str){
    System.out.println("StaticDefaultMethodInterface::isNull");
    return str!=null && str.length()!=0;
  }
  
}

public class StaticMethodImpl implements StaticDefaultMethodInterface{
  public boolean isNull(String str){
    System.out.println("StaticMethodImpl::isNull");
    return str!=null;
  }
  
  // public void print(String str){
  //   System.out.println("StaticMethodImpl::print");
  //   if(!isNull(str)){
  //     System.out.println("Impl:: " +str+ " is something");      
  //   }
  //}
  
  public static void main(String[] args){
    StaticDefaultMethodInterface impl = new StaticMethodImpl();
    impl.print("Domer");
  }
  
}
