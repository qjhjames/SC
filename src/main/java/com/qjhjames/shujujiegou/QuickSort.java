package com.qjhjames.shujujiegou;

/**
 * Created by qiujunhong on 2018/7/12.
 */
public class QuickSort {
    static void show(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    static void quickSort(int[] a,int begin,int end){
        if(end-begin<=1)return;

        int x=a[begin];//标尺
        int p1=begin;
        int p2=end;

        boolean dr=true; //比较方向

L1:        while (p1<p2){
            if(dr){
               for(int i=p2;i>p1;i--){
                   if(a[i]<=x){
                       a[p1++]=a[i];
                       p2=i;
                       dr=!dr;
                       continue L1;
                   }
               }
               p2=p1;
            }else {
                for(int i=p1;i<p2;i++){
                    if(a[i]>=x){
                        a[p2--]=a[i];
                        p1=i;
                        dr=!dr;
                        continue L1;
                    }
                }
                p1=p2;
            }
        }
        a[p1]=x;

        quickSort(a,begin,p1-1);
        quickSort(a,p1+1,end);
    }

    public static void main(String[] args){
        int[] a={15,22,13,9,16,33,15,23,18,4,33,25,14};

        quickSort(a,0, a.length-1);

        show(a);
    }

}
