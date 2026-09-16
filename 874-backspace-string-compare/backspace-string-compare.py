class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        stack1 = []
        stack2 = []

        for i in range(len(s)):
            ch = s[i]

            if not stack1:
                if ch == '#':
                    continue

                stack1.append(ch)
                continue

            if ch == '#':
                stack1.pop()
            else:
                stack1.append(ch)

        for i in range(len(t)):
            ch = t[i]

            if not stack2:
                if ch == '#':
                    continue

                stack2.append(ch)
                continue

            if ch == '#':
                stack2.pop()
            else:
                stack2.append(ch)

        if len(stack1) != len(stack2):
            return False

        if not stack1 and not stack2:
            return True

        while stack1:
            if stack1[-1] != stack2[-1]:
                return False

            stack1.pop()
            stack2.pop()

        return True