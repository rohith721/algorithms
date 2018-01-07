package datastructures;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo)return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a,int lo,int hi){
        int i=lo; int j=hi+1;
        while (true){
            while(less(a[++i],a[lo]))if(i==hi)break;
            while(less(a[lo],a[--j]))if(j==lo)break;
            if(i>=j)break;
            exchng(a,i,j);
        }
        exchng(a,lo,j);
        return j;
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exchng(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args) {
 QuickSort quickSort = new QuickSort();
 Integer[] a ={2,4,3,6,7,1,8,9,10,12,11};
 quickSort.sort(a);
 for(int i=0;i<a.length;i++){
     System.out.println(a[i]);
 }
    }
}
