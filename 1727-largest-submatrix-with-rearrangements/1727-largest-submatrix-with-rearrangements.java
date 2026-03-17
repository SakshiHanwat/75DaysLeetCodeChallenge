import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] height = new int[n];
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            
            int[] temp = height.clone();
            Arrays.sort(temp);
            
            for (int j = n - 1; j >= 0; j--) {
                int width = n - j;
                ans = Math.max(ans, temp[j] * width);
            }
        }
        
        return ans;
    }
}