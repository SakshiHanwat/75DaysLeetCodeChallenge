class Solution {
    public int[] twoSum(int[] nums, int target) {
        int two_sum [] = new int[2];

        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    two_sum[0] = i;
                    two_sum[1] = j;
                }
            }
        }
        return two_sum;
    }
}