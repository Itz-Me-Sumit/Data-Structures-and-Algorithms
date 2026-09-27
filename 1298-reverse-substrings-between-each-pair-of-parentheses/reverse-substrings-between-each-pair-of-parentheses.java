class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();
        String res = "";

        for(int i=0 ; i<s.length() ; i++){
            Character ch = s.charAt(i);

            if(ch!=')'){
                stack.push(ch);
            }
            else{
                while(stack.peek()!='('){
                    queue.add(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()){
                    stack.push(queue.poll());
                }
            }
        }

        while(!stack.empty()){
            res += stack.pop();
        }

        return new StringBuilder(res).reverse().toString();
    }
}