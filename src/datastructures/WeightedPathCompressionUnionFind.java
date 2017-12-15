package datastructures;

public class WeightedPathCompressionUnionFind {
    private int[] id;
    private int[] sz;
    private WeightedPathCompressionUnionFind(int N){
        id = new int[N];
        sz = new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
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
    public void union(int p,int q){
        int i = root(p);
        int j=root(q);
        if(sz[i]<sz[j]){
            id[i]=j;
            sz[j]+=sz[i];
        }
        else{
            id[j]=i;
            sz[i]+=sz[j];
        }
    }
    public static void main(String[] args) {
        WeightedPathCompressionUnionFind uf = new WeightedPathCompressionUnionFind(9);
        uf.union(2,3);
        uf.union(3,4);
        uf.union(5,6);
        uf.union(6,7);
        uf.union(5,2);

    }
}
