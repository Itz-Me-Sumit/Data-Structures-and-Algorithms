class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(stack.empty()){
                stack.push(ch);
                continue;
            }

            if(
                (stack.peek() == '(' && ch == ')') ||
                (stack.peek() == '{' && ch == '}') ||
                (stack.peek() == '[' && ch == ']')
            ){
                stack.pop();
            }
            else{
                stack.push(ch);
            }

        }

        return stack.empty();

    }
}