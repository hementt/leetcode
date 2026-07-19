class Solution {
    public String smallestSubsequence(String s) {
        int []  freq = new int[26];
        for(char c : s.toCharArray()) freq[c - 'a']++;

        boolean isVis[] = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            freq[c- 'a']--;

            if(isVis[c - 'a'] == true){
                continue;
            }

            while(!stack.isEmpty() && freq[stack.peek() - 'a'] >= 1 && stack.peek() > c){
                isVis[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            isVis[c - 'a'] = true;            
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}