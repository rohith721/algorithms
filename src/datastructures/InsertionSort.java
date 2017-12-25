package datastructures;

public class InsertionSort {
    public static void sort(Comparable[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i;j>0;j--) {
                if (less(a[j], a[j-1])) {
                    exchng(a,j,j-1);
                }
                assert isSorted(a);
            }
assert isSorted(a,0,a.length-1);
        }
    }
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exchng(Comparable[] a, int i , int j){
        Comparable temp = a[j];
        a[j]=a[i];
        a[i]=temp;
    }
    public static void main(String[] args) {
        Integer[] a ={2,1,3,5,4};
        InsertionSort.sort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);}
    }
}
