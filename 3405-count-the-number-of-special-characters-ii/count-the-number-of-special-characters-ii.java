class Solution {
    public int numberOfSpecialChars(String word) {
        int [] upper = new int[26];
        int [] lower = new int[26];
        Arrays.fill(lower, -1);
        Arrays.fill(upper, Integer.MAX_VALUE);


        for(int i =0; i<word.length();i++){
            if(Character.isLowerCase(word.charAt(i))){
                lower[word.charAt(i) - 'a'] = i;
            }
            if(Character.isUpperCase(word.charAt(i))){
                upper[word.charAt(i) - 'A'] = Math.min(i, upper[word.charAt(i) - 'A']);
            }
        }    
        int res = 0;
        for(int i =0;i<26;i++){
            if(lower[i] != -1 && upper[i] != Integer.MAX_VALUE){
                if(lower[i] < upper[i]) res++;
            }
        }
        return res;
         
    }
}