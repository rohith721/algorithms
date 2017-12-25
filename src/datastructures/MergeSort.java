package datastructures;

import edu.princeton.cs.algs4.In;

public class MergeSort  {
    private static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi){
        for(int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }
        int i = lo;int j =mid+1;
        for(int k=lo;k<=hi;k++){
            if(i>mid)a[k]=aux[j++];
           else if(j>hi)a[k]=aux[i++];
           else if(less(a[j],a[i])){
                a[k]=aux[j++];
            }
            else {
                a[k]=aux[i++];
            }
        }
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void sort(Comparable[] a , Comparable[] aux,int lo,int hi){
       if(hi<=lo)return;
       int mid = lo + (hi-lo)/2;
       sort(a,aux,lo,mid);
       sort(a,aux,mid+1,hi);
       merge(a,aux,lo,mid,hi);
    }
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    public static void main(String[] args) {
        Integer[] a = {3,2,4,5,1,6,8,7,9};
        MergeSort.sort(a);
        for (int i=0;i<a.length;i++){
        System.out.println(a[i]);
    }
}}
