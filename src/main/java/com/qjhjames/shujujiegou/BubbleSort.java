package com.qjhjames.shujujiegou;

/**
 * Created by qiujunhong on 2018/7/14.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] arr={3,2,8,9,32,56,1,49};
        System.out.println("交换之前");
        for(int num:arr){
            System.out.print(num+" ");
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++)
            if(arr[j]<arr[j+1]){
                int temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
            }
        }
        System.out.println();
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
