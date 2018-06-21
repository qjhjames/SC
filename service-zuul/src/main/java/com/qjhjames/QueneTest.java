package com.qjhjames;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/6/15.
 */
public class QueneTest {
   public static void main(String[] args){
       BlockingQueue<String> queue=new ArrayBlockingQueue<String>(3);
       for(int i=0;i<4;i++){
           queue.add("aa");
           System.out.println(i);
       }
      // Set<String> strings
   }
}

