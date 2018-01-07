package datastructures;

import edu.princeton.cs.algs4.StdRandom;

public class ThreeWayQuickSort {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int lo,int hi){
        if(hi<=lo)return;
        int i=lo+1;
        int lt=lo;
        int gt=hi;
        Comparable v = a[lo];
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0)exchng(a,lt++,i++);
            else if(cmp>0)exchng(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
    private static void exchng(Comparable[] a , int i, int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args) {

        ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();
        Integer[] a ={2,4,3,6,7,1,8,9,10,12,11};
        threeWayQuickSort.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
