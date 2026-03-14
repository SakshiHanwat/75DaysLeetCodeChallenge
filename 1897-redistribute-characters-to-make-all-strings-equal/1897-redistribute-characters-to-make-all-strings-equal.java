class Solution {
    public boolean makeEqual(String[] words) {

        int[] freq = new int[26];

        for(String word : words){
            for(char c : word.toCharArray()){
                freq[c - 'a']++;
            }
        }

        int n = words.length;

        for(int f : freq){
            if(f % n != 0){
                return false;
            }
        }

        return true;
    }
}