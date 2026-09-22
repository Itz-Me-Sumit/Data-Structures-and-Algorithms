from collections import deque

class Solution:
    def timeRequiredToBuy(self, tickets: list[int], k: int) -> int:

        q = deque()

        for i in range(len(tickets)):
            q.append(i)
        
        time = 0

        while(tickets[k] != 0):
            top = q[0]
            tickets[top]-=1
            q.popleft()
            time+=1
            if(tickets[top] > 0):
                q.append(top)
        
        return time