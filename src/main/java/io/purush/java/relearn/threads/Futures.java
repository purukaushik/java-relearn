package io.purush.java.relearn.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

public class Futures {
  public static void main(String[] args) throws Exception {
    ExecutorService executor = new ThreadPoolExecutor(4,4,1, TimeUnit.MINUTES,
						      new LinkedBlockingQueue<Runnable>());
    Future<ReturnableObject> f1 = executor.submit(new TerribleFuture());
    Future<ReturnableObject> f2 = executor.submit(new BadFuture());
    //System.out.println(f1.get() + " " + f2!=null ? f2.get(): "NULL");
    executor.shutdown();
    
  }
  private static class ReturnableObject{
    int returnValue;
    String badValue;
  }
  private static class TerribleFuture implements Callable<ReturnableObject> {
    @Override
    public ReturnableObject call() throws Exception {
      ReturnableObject returnableObject = new ReturnableObject();
      returnableObject.returnValue  = -1;
      returnableObject.badValue = "Bad stuff going on";
      Thread.sleep(500);
      return returnableObject;
    }
  }
  private static class BadFuture implements Callable<ReturnableObject> {
    @Override
    public ReturnableObject call() throws Exception {
      Thread.sleep(50);
      return null;
    }
  }
}

