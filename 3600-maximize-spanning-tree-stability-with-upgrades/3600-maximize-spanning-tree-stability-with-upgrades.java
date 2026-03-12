import java.util.*;

class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean unite(int x, int y){
            int rx = find(x);
            int ry = find(y);

            if(rx == ry) return false;

            if(rank[rx] < rank[ry]){
                int temp = rx;
                rx = ry;
                ry = temp;
            }

            parent[ry] = rx;

            if(rank[rx] == rank[ry])
                rank[rx]++;

            return true;
        }
    }


    boolean canBuild(int n, int[][] edges, int k, int stability){

        DSU dsu = new DSU(n);
        int upgradesUsed = 0;

        List<int[]> optionalEdges = new ArrayList<>();

        for(int[] e : edges){

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if(must == 1){

                if(s < stability)
                    return false;

                dsu.unite(u,v);
            }
            else{

                if(s >= stability){
                    dsu.unite(u,v);
                }
                else if(2 * s >= stability){
                    optionalEdges.add(new int[]{2 * s, u, v});
                }
            }
        }


        for(int[] e : optionalEdges){

            int s = e[0];
            int u = e[1];
            int v = e[2];

            if(dsu.find(u) != dsu.find(v)){

                if(upgradesUsed >= k)
                    return false;

                dsu.unite(u,v);
                upgradesUsed++;
            }
        }


        int root = dsu.find(0);

        for(int i = 1; i < n; i++){
            if(dsu.find(i) != root)
                return false;
        }

        return true;
    }


    public int maxStability(int n, int[][] edges, int k) {

        int low = 1;
        int high = 0;

        DSU dsu = new DSU(n);

        for(int[] e : edges){

            int u = e[0];
            int v = e[1];
            int s = e[2];

            if(e[3] == 1){

                if(!dsu.unite(u,v))
                    return -1;

                high = Math.max(high, s);
            }
            else{
                high = Math.max(high, s * 2);
            }
        }

        int ans = -1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(canBuild(n, edges, k, mid)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;
    }
}