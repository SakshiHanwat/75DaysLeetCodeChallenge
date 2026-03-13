class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long) workerTimes[0] * mountainHeight * (mountainHeight + 1) / 2;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (canFinish(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canFinish(long T, int mountainHeight, int[] workerTimes) {
        long totalReduction = 0;
        
        for (int t : workerTimes) {
            long x = (long)((-1 + Math.sqrt(1 + 8.0 * T / t)) / 2);
            totalReduction += x;
            if (totalReduction >= mountainHeight) return true;
        }
        
        return totalReduction >= mountainHeight;
    }
}