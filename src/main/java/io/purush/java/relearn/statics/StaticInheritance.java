package io.purush.java.relearn.statics;

public class StaticInheritance {
  public static void main(String[] args){
    Top top = new ExtendsTop();
    // Idea is that the statics are based on reference
    //hence first call is to Top.useless()
    top.useless();
    // once casted down to ExtendsTop, call is to ExtendsTop.useless()
    ((ExtendsTop)top).useless();

    // Unlike normal inheritance where
    // both calls are to ExtendsTop.call()
    top.call();
    ((ExtendsTop)top).call();
  }
}

class Top {
  static void useless(){
    System.out.println("Top.useless");
    
  }
  public void call(){
    System.out.println("Top.call");
    
  }
}

class ExtendsTop extends Top {
  static void useless(){
    System.out.println("ExtendsTop.useless");
    
  }
  @Override
  public void call(){
    System.out.println("ExtendsTop.call");
    
  }
}
