class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();
        for(char c : word.toCharArray()) set.add(c);

        int res = 0;
        for(int i =0; i<26;i++){
            char lower = (char)(i + 'a');
            char upper = (char)(i + 'A');

            boolean l = false;
            boolean u = false;
            boolean flag = true;
            if(set.contains(lower) && set.contains(upper)){
                for(int j =0; j<word.length();j++){
                char ch = word.charAt(j);
                if(ch == upper) u = true;
                if(ch == lower) l = true;

                if(u && !l){ flag = false; break;}
                if(u && ch == lower) {flag = false; break;}
            }
            }
            if(l && u && flag) res++;
        }
        return res;
    }
}