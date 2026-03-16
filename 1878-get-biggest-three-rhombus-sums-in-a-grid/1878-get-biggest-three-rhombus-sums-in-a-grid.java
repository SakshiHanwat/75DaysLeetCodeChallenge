import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                set.add(grid[i][j]);
                if(set.size() > 3) set.pollFirst();

                for(int k = 1; i-k >= 0 && i+k < m && j-k >= 0 && j+k < n; k++){

                    int sum = 0;

                    int r = i-k, c = j;

                    while(r < i && c < j+k){
                        sum += grid[r][c];
                        r++; c++;
                    }

                    while(r < i+k && c > j){
                        sum += grid[r][c];
                        r++; c--;
                    }

                    while(r > i && c > j-k){
                        sum += grid[r][c];
                        r--; c--;
                    }

                    while(r > i-k && c < j){
                        sum += grid[r][c];
                        r--; c++;
                    }

                    set.add(sum);

                    if(set.size() > 3){
                        set.pollFirst();
                    }
                }
            }
        }

        int[] ans = new int[set.size()];
        int i = ans.length - 1;

        for(int val : set){
            ans[i--] = val;
        }

        return ans;
    }
}