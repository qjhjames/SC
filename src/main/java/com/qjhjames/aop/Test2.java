package com.qjhjames.aop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by qiujunhong on 2018/7/19.
 */
public class Test2 {
   /* public static void main(String[] args){
        String a="aa";
        String b="bb";
        System.err.print(a==b);
    }*/

   /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意这里的数组，不是int的
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return -1;
                if (o1 < o2) return 1;
                return 0;
            }

        });
        System.err.println(Arrays.toString(arr));
    }*/

    public static Test2 t1=new Test2();
    {
        System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {
        //Test2 t2=new Test2();
        Integer a=100;
        Integer b=100;
        System.out.println(a==b);
    }




}
