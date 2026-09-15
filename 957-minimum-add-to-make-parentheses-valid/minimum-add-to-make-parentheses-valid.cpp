class Solution {
public:
    int minAddToMakeValid(string s) {
        
        stack<char> stack;

        for(int i = 0 ; i < s.size() ; i++){
            char ch = s[i];

            if(stack.empty()){
                stack.push(ch);
                continue;
            }

            if(stack.top() == '(' && ch == ')'){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        return stack.size();

    }
};