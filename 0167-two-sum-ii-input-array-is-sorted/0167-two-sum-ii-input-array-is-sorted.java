class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans1 = new int[2];

        int start = 0 ;
        int end = numbers.length-1 ;

        while(start<end){
            int sum = numbers[start] + numbers[end];

            if(sum == target){
                ans1[0] = start+1 ;
                ans1[1] = end+1 ;

                return ans1 ;
            }else if ( sum > target){
                end--;
            }else{
                start++;
            }
        }

        return ans1;
    }
}