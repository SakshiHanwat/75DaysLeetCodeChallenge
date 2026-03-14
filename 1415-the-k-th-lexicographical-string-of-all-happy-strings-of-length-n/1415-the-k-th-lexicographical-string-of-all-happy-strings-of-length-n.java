class Solution {
    int N;
    char[] ls={'a','b','c'};
    public String getHappyString(int n, int k) {
        N=n;
        ArrayList<String> ans=new ArrayList<>();
        solve(0,"",ans);
        if(k<=ans.size()) return ans.get(k-1);
        return "";
    }
    public void solve(int i,String s,ArrayList<String> ans){
        if(i==N) {
            ans.add(s.toString());
            return;
        } 
        for(int j=0;j<3;j++){
            if(s.isEmpty() || ls[j] != s.charAt(s.length()-1)){
                solve(i+1,s+ls[j],ans);
            }
        }

    }
}