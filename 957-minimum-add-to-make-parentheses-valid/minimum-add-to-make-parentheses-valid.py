class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        
        stack = []

        for ch in s:
            if(not stack):
                stack.append(ch)
                continue
            if stack[-1] == '(' and ch == ')':
                stack.pop()
            else:
                stack.append(ch)
        return len(stack)