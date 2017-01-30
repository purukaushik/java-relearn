package io.purush.java.relearn.threads;

import java.util.concurrent.BlockingQueue;
import java.lang.Runnable;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
/*
 * BlockingQueue methods
 * 1. Throws exception if not possible -> add, remove, element
 * 2. Throw back a special value true/false if not possible -> offer, poll, peek
 * 3. Block until available -> put, take
 * 4. Time out if not available after -> offer(o, timeout, TimeUnit), poll(...)
 */

/* Implementations of interface
 * ArrayBlockingQueue, DelayQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue
 */

public class BlkQueue {
  
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue queue = new ArrayBlockingQueue(1024);
    Producer p = new Producer(queue);
    Consumer c = new Consumer(queue);
    new Thread(p).start();
    new Thread(c).start();
    Thread.sleep(4000);
  }
}
class Producer implements Runnable {
  protected BlockingQueue q = null;
  public Producer(BlockingQueue q) {this.q=q;}
  public void run(){
    try{
      q.put("1");
      Thread.sleep(1000);
      q.put("2");
      Thread.sleep(1000);
      q.put("3");
    } catch(InterruptedException e){
      System.out.println("Interrupted Producer");
      
    }
  }
}

class Consumer implements Runnable {
  protected BlockingQueue q;
  public Consumer(BlockingQueue q ) { this.q = q;}
  public void run(){
    try {
    System.out.println(q.take());
    System.out.println(q.take());
    } catch( InterruptedException e){
      e.printStackTrace();
    }
    
  }
}
