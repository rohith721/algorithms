package datastructures;

public class SelectionSort {
    public static void sort(Comparable[] a){
        for(int i=0;i<a.length;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
              exchng(a,i,min);
        }

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
        SelectionSort.sort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);}
    }
}
