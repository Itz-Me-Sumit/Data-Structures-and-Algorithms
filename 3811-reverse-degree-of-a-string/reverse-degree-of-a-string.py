class Solution(object):
    def reverseDegree(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0

        for i in range(len(s)):
            string_index = i+1
            reversed_index = 26 - ( ord(s[i])%97 )
            res += string_index * reversed_index

        return res
        