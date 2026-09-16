class Solution:
    def isValid(self, s: str) -> bool:
        
        stack = []

        for ch in s:
            if(not stack):
                stack.append(ch)
                continue
            if( (stack[-1] == '(' and ch == ')') or (stack[-1] == '{' and ch == '}') or(stack[-1] == '[' and ch == ']') ):
                stack.pop()
            else:
                stack.append(ch)
        
        return len(stack) == 0            