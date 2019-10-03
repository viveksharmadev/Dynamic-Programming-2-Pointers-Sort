// https://leetcode.com/problems/longest-common-subsequence/

class longest-common-subsequence {
    // tc -> m*n, sc-> m*n
    public int longestCommonSubsequence(String text1, String text2) {
        return getMaxLCS(text1, text2,0,0, 
                         new int[text1.length()][text2.length()]);
    }
    
    private int getMaxLCS(String t1, String t2, int i1, int i2, 
                          int[][] cache){
        if(i1==t1.length() || i2==t2.length()){
            return 0;
        }
        if(cache[i1][i2]!=0) return cache[i1][i2];
        int res = 0;
        if(t1.charAt(i1)==t2.charAt(i2)){
            res = 1+getMaxLCS(t1,t2,i1+1,i2+1, cache);            
        }else{
            res = Math.max(getMaxLCS(t1,t2,i1+1,i2, cache), getMaxLCS(t1,t2,i1,i2+1, cache));
        }
        cache[i1][i2] = res;
        return res;
    }
}
