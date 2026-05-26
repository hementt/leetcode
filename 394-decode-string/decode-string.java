class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack <Character> stack = new Stack<>();

        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == ']'){
                
                StringBuilder temp = new StringBuilder();
                while(stack.peek() != '['){
                    temp.append(stack.pop());
                }
                temp.reverse();
                if(stack.peek() == '[') stack.pop();

                int num = 0;
                int base = 1;

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num = num + (stack.pop() - '0') * base;
                    base *= 10;
                }

                String str = temp.toString();

                while (num-- > 0) {
                    for (char c : str.toCharArray()) {
                        stack.push(c);
                    }
                }

            }else{
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}