class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;

        Stack <Character> stack = new Stack<>();
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    res++;
                    continue;
                }
                char peek = stack.peek();
                if(ch == ')' && peek == '(' ){
                    stack.pop();
                }else{
                    res++;
                }
            }
        }
        return res + stack.size();
    }
}