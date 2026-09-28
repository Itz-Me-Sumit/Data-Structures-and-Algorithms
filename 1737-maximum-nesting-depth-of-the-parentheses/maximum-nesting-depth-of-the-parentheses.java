class Solution {
    public int maxDepth(String s) {
        
        Stack<Integer> stack = new Stack<>();

        int max = 0;


        for(int i=0 ; i<s.length() ; i++){

            char ch = s.charAt(i);

            if(stack.empty() && ch == '('){
                stack.push(1);
                if(stack.peek() > max){
                    max = stack.peek();
                }
                continue;
            }

            if(ch=='('){
                stack.push( stack.peek() + 1 );
            }

            if(ch == ')'){
                if(stack.peek() > max){
                    max = stack.peek();
                }
                stack.pop();
            }

        }

        return max - stack.size();

    }
}