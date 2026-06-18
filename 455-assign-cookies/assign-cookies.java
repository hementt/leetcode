class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int j =0;
        for(int i =0;i<s.length;i++){
            if(j == g.length) break;
            if(s[i] >= g[j]){
                j++;
                res++;
            }
        }
        return res;
    }
}