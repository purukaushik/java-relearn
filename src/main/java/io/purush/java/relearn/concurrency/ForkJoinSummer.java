package io.purush.java.relearn.concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.lang.*;
import java.io.*;

class MergeSort<T extends Comparable<? super T>> extends RecursiveAction {
  private final T[] in;
  private final T[] temp;
  private final int start;
  private final int finish;
  
  public MergeSort(T[] in, T[] temp, int start, int finish){
    this.in= in;
    this.temp = temp;
    this.start= start;
    this.finish = finish;
  }

  @Override
  protected void compute(){
    if(start >= finish) return;
    int mid = (start+finish)/2;
    MergeSort<T> left = new MergeSort<>(in, temp, start, mid);
    MergeSort<T> right = new MergeSort<>(in, temp, mid+1, finish);
    invokeAll(left,right);
    merge(this.in, this.temp, this.start, mid, this.finish);
  }
  private void merge(T[] in, T[] temp, int start, int mid, int finish){
    for(int i=start; i<=finish;i++){
      temp[i] = in[i];
    }
    int i=start, j= mid+1;
    for(int k=start;k<=finish;k++){
      if(i>mid){
	in[k] = temp[j++];
      }else if(j>finish){
	in[k] = temp[i++];
      }else if(less(temp[i],temp[j])){
	in[k] = temp[i++];
      }else{
	in[k] = temp[j++];
      }
    }
  }
  private  boolean less(T a, T b){
    return a.compareTo(b) < 0 ;
  }
}
class VanillaMergeSort<T extends Comparable<? super T>> {
  private final T[] in;
  private final T[] temp;
  private final int start;
  private final int finish;
  
  public VanillaMergeSort(T[] in, T[] temp, int start, int finish){
    this.in= in;
    this.temp = temp;
    this.start= start;
    this.finish = finish;
  }

  
  protected void compute(){
    if(start >= finish) return;
    int mid = (start+finish)/2;
    VanillaMergeSort<T> left = new VanillaMergeSort<>(in, temp, start, mid);
    VanillaMergeSort<T> right = new VanillaMergeSort<>(in, temp, mid+1, finish);
    left.compute(); right.compute();
    merge(this.in, this.temp, this.start, mid, this.finish);
  }
  private void merge(T[] in, T[] temp, int start, int mid, int finish){
    for(int i=start; i<=finish;i++){
      temp[i] = in[i];
    }
    int i=start, j= mid+1;
    for(int k=start;k<=finish;k++){
      if(i>mid){
	in[k] = temp[j++];
      }else if(j>finish){
	in[k] = temp[i++];
      }else if(less(temp[i],temp[j])){
	in[k] = temp[i++];
      }else{
	in[k] = temp[j++];
      }
    }
  }
  private  boolean less(T a, T b){
    return a.compareTo(b) < 0 ;
  }
}
public class ForkJoinSummer {
  // Idea is to do partial sums over a huge array in parallel.
  public static void main(String[] args){
    int LIMIT = 1_000_000;
    Integer[] toSort = new Integer[LIMIT];
    Integer[] superTemp = new Integer[LIMIT];
    for(int i=0; i< LIMIT; i++){
      toSort[i] = new Random().nextInt();
    }
    Integer[] copiedOver = Arrays.copyOf(toSort, LIMIT);
    Integer[] thirdVersion = Arrays.copyOf(toSort, LIMIT);
    Integer[] copiedOver1 = Arrays.copyOf(toSort, LIMIT);
    // parallel merge sort
    long start = System.currentTimeMillis();
    ForkJoinPool forkJoinPool = new ForkJoinPool(100);
    forkJoinPool.invoke(new MergeSort(toSort, superTemp, 0, toSort.length-1));
    forkJoinPool.shutdown();
    long end = System.currentTimeMillis();
    System.out.println("Time taken in parallel sort -> " + (end-start) + "us");
    
    PrintWriter pw = new PrintWriter(System.out);

    // system quick sort serial
    start = System.currentTimeMillis();
    Arrays.sort(copiedOver);
    end = System.currentTimeMillis();
    System.out.println("Time taken in system sort -> " + (end-start) + "us");
    
    pw.println(Arrays.equals(copiedOver, toSort) ? " Eq" : " NE");

    // normal merge sort impl
    start = System.currentTimeMillis();
    VanillaMergeSort<Integer> vamergeSort  = new VanillaMergeSort(thirdVersion, new Integer[LIMIT], 0, thirdVersion.length-1);
    vamergeSort.compute();
    end = System.currentTimeMillis();
    System.out.println("Time taken in normal sort -> " + (end-start) + "us");
    pw.println(Arrays.equals(copiedOver, thirdVersion) ? " Eq" : " NE");

    // system parallel sort
    start = System.currentTimeMillis();
    Arrays.parallelSort(copiedOver1);
    end = System.currentTimeMillis();
    System.out.println("Time taken in system parallel sort -> " + (end-start) + "us");
    pw.flush();
    pw.close();
  }
  
}
