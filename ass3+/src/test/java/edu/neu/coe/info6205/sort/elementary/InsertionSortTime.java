package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.*;
import edu.neu.coe.info6205.util.*;
import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

public class InsertionSortTime {
    @Test
    public void RandomTest() {
        InsertionSort insertionSort = new InsertionSort();
        Benchmark_Timer<Integer[]> timer = new Benchmark_Timer<Integer[]>("random",null,(x)->insertionSort.sort(x),null);
        for(int n = 1000 ; n <= 16000; n=n*2){
            int len=n;
            Supplier<Integer[]> supplier = new Supplier<Integer[]>() {
                @Override
                public Integer[] get() {
                    Random random = new Random();
                    Integer[] arr = new Integer[len];
                    for(int i = 0 ; i < len ; i++){
                        arr[i] = random.nextInt(len);
                    }
                    return arr;
                }
            };
            double time = timer.runFromSupplier(supplier,10);
            System.out.println("value n:" + n + "time:" + time);
        }
    }

    @Test
    public void OrderedTest() {
        InsertionSort insertionSort = new InsertionSort();
        Benchmark_Timer<Integer[]> timer = new Benchmark_Timer<Integer[]>("ordered",null,(x)->insertionSort.sort(x),null);
        for(int n = 1000 ; n <= 16000; n=n*2){
            int len=n;
            Supplier<Integer[]> supplier = new Supplier<Integer[]>() {
                @Override
                public Integer[] get() {
                    Integer[] arr = new Integer[len];
                    for(int i = 0 ; i < len ; i++){
                        arr[i] = i;
                    }
                    return arr;
                }
            };
            double time = timer.runFromSupplier(supplier,10);
            System.out.println("value n:" + n + "time:" + time);
        }
    }

    @Test
    public void partOrderedTest() {
        InsertionSort insertionSort = new InsertionSort();
        Benchmark_Timer<Integer[]> timer = new Benchmark_Timer<Integer[]>("partordered",null,(x)->insertionSort.sort(x),null);
        for(int n = 1000 ; n <= 16000; n=n*2){
            int len=n;
            Supplier<Integer[]> supplier = new Supplier<Integer[]>() {
                @Override
                public Integer[] get() {
                    Random random = new Random();
                    Integer[] arr = new Integer[len];
                    for(int i = 0 ; i < len ; i++) {
                        if (i <= len / 2) arr[i] = random.nextInt(len / 2);
                        else arr[i] = i;
                    }
                    return arr;
                }
            };
            double time = timer.runFromSupplier(supplier,10);
            System.out.println("value n:" + n + "time:" + time);
        }
    }

    @Test
    public void ReverseTest() {
        InsertionSort insertionSort = new InsertionSort();
        Benchmark_Timer<Integer[]> timer = new Benchmark_Timer<Integer[]>("reverse",null,(x)->insertionSort.sort(x),null);
        for(int n = 1000 ; n <= 16000; n=n*2){
            int len=n;
            Supplier<Integer[]> supplier = new Supplier<Integer[]>() {
                @Override
                public Integer[] get() {
                    Integer[] arr = new Integer[len];
                    for(int i = 0 ; i < len ; i++){
                        arr[i] = len-i;
                    }
                    return arr;
                }
            };
            double time = timer.runFromSupplier(supplier,10);
            System.out.println("value n:" + n + "time:" + time);
        }
    }


}
