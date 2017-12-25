package datastructures;

public class InversionInArray {
    private static int merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1; int count = 0;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(a[j], a[i])) {
                a[k] = aux[j++];
                count+=mid-i+1; //length so add 1

            } else {
                a[k] = aux[i++];
            }
        }
        return count;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static int sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        int count1=sort(a, aux, lo, mid);
        int count2=sort(a, aux, mid + 1, hi); // inversion in list a
        int count3=merge(a, aux, lo, mid, hi); // inversion in list b
        return count1+count2+count3; // inversion while merging them
    }

    public static int sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        return sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] a = {2, 4, 1, 3, 5};
        System.out.println(InversionInArray.sort(a));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}