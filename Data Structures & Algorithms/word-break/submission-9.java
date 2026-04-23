class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), "");
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 0; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && map.containsKey(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
