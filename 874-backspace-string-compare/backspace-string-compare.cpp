class Solution {
public:
    bool backspaceCompare(string s, string t) {
        
        stack<char> stack1;
        stack<char> stack2;

        for(int i = 0; i < s.length(); i++){
            char ch = s[i];

            if(stack1.empty()){

                if(ch == '#') continue;

                stack1.push(ch);
                continue;
            }

            if(ch == '#'){
                stack1.pop();
            }
            else{
                stack1.push(ch);
            }
        }

        for(int i = 0; i < t.length(); i++){
            char ch = t[i];

            if(stack2.empty()){

                if(ch == '#') continue;

                stack2.push(ch);
                continue;
            }

            if(ch == '#'){
                stack2.pop();
            }
            else{
                stack2.push(ch);
            }
        }

        if(stack1.size() != stack2.size()){
            return false;
        }

        if(stack1.empty() && stack2.empty()){
            return true;
        }

        while(!stack1.empty()){
            if(stack1.top() != stack2.top()){
                return false;
            }

            stack1.pop();
            stack2.pop();
        }

        return true;
    }
};