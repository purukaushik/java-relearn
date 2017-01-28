package io.purush.java.relearn.collections;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
  public static void main(String[] args) throws Exception{
    // Random keys are useless example
    Map<Key, Integer> map = new HashMap<>();
    map.put(new Key(5),0);
    Key getThisOne = new Key(5);
    System.out.println( map.get(getThisOne)); // => get will always return null as hashcode returns random numbers
    // Synchronized maps
    Map<Integer, Integer> map1 = new HashMap<>();
    //Map<Integer, Integer> syncMap = Collections.synchronizedMap(map1);
    ExecutorService pool = Executors.newFixedThreadPool(1000);

    
    IntStream.range(0,1000).forEach( x -> {
	pool.submit(new RunThis(map1));
      });
    pool.shutdown();
    pool.awaitTermination(30, TimeUnit.SECONDS);
    System.out.println("On completion -> map1 ->" +map1);
    //System.out.println("              SyncMap -> " + syncMap);
  }
}
class RunThis implements Runnable {
  Map<Integer, Integer> syncMap;
  public RunThis(Map<Integer,Integer> syncMap){
    this.syncMap = syncMap;
  }
  @Override
  public void run(){
    String id = Thread.currentThread().getId() + "";
    
    System.out.println(id+ ": Current vals -> " +syncMap.getOrDefault(0, 0));
    //System.out.println(id +": Updating map's 0 element...");
    syncMap.put(0,syncMap.getOrDefault(0, 0)+1);
    
  }
}
class Key {
  private int value =0;
  public Key(int value){ this.value = value;}
  @Override
  public int hashCode(){ return new Random().nextInt();}
  @Override
  public boolean equals(Object o){
    if(!(o instanceof Key)) return false;
    Key that = (Key)o;
    return that.value == this.value;
  }
}
