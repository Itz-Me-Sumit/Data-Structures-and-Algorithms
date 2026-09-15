class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """

        stack = []

        for ch in s:
            stack.append(ch)
        for i in range(len(s)):
            s[i] = stack.pop()
        