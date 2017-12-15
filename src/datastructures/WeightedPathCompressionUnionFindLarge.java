
/**
 Add a method large() to the union-find data type so that large(i) returns the largest element in the connected component containing i


 * The operations, union(), connected(), and large() should all take logarithmic time or better.

 * For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.


*/
package datastructures;

public class WeightedPathCompressionUnionFindLarge {
    private int[] id;
    private int[] sz;
    private int[] large;
    public WeightedPathCompressionUnionFindLarge(int N){
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
            large[i]=i;
        }

    }
    private int root(int p){
        while(p!=id[p]){
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }
    public boolean connected(int p,int q){
        return root(p)==root(q);
    }
    public int large(int p){
        return large[root(p)];
    }
    public void union(int p,int q){
        int i = root(p);
        int j=root(q);
        int largeP = root(p);
        int largeQ = root(q);
        if(sz[i]<sz[j]){
            id[i]=j;
            sz[j]+=sz[i];
            if(largeP>largeQ){
                large[largeQ]=largeP;
            }
        }
        else{
            id[j]=i;
            sz[i]+=sz[j];
            if(largeQ>largeP){
                large[largeP]=largeQ;
            }
        }
    }
    public static void main(String[] args) {
        WeightedPathCompressionUnionFindLarge uf = new WeightedPathCompressionUnionFindLarge(9);
        uf.union(2,3);
        uf.union(3,4);
        uf.union(5,6);
        uf.union(6,7);
        uf.union(5,2);
        uf.union(5,8);

    }
}
