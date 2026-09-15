class Solution {

    // public Boolean closingParantheses(char a , char b){



    // }

    public int minAddToMakeValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        if(s.length() == 0){
            return 0;
        }

        for(int i = 0 ; i<s.length() ; i++){

            char ch = s.charAt(i);
            
            if(stack.empty()){
                stack.push(ch);
                continue;
            }

            if(stack.peek() == '(' && ch == ')'){
                stack.pop();
            }
            else{
                stack.push(ch);
            }

        }

        return stack.size();

    }
}