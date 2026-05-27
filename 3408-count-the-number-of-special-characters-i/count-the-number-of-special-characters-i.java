class Solution {
    public int numberOfSpecialChars(String word) {
        boolean a[] = new boolean[26];
        boolean b[] = new boolean[26];

        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                a[ch - 'a'] = true;
            }else{
                b[ch- 'A'] = true;
            }
        }

        int res =0;
        for(int i =0; i<26;i++){
            if(a[i] && b[i]) res++;
        }
        return res;
    }
}