class Solution {
    public boolean isMatch(String s, String p) {
        return solve(0,0,s, p);
    }
    public boolean solve(int i , int j , String s, String p){
        if(i == s.length() && j >= p.length()){
            return true;
        }
        if(i == s.length()){
            while(j < p.length()){
                if(j+1 < p.length() && p.charAt(j+1) == '*'){
                    j+=2;
                }else{
                    return false;
                }
            }
            return true;
        }        
        if(j >= p.length()) return false;


        boolean first = false;
        boolean second = false;
        boolean third = false;

        if((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && 
        (j+1 < p.length() && p.charAt(j + 1) == '*')){
            second = solve(i, j+2, s, p) || solve(i+1, j, s, p);
        }else if((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && 
        (j+1 >=  p.length() || p.charAt(j+ 1) != '*')){
            first = solve(i+1, j+1, s, p);
        }else if((s.charAt(i) != p.charAt(j)) && 
        (j+1 < p.length() && p.charAt(j+ 1) == '*')){
            third = solve(i, j+2, s, p);
        }

        return first || second || third;
    }
}