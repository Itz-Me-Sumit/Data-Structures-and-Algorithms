from collections import deque

class MyStack:

    queue1 = None
    queue2 = None

    def __init__(self):
        self.queue1 = deque()
        self.queue2 = deque()

    def push(self, x: int) -> None:
        filled_queue = self.queue1 if self.queue1 else self.queue2
        filled_queue.append(x)

    def pop(self) -> int:
        filled_queue = self.queue1 if self.queue1 else self.queue2
        empty_queue = self.queue1 if not self.queue1 else self.queue2
        
        size = len(filled_queue)
        for _ in range(size-1):
            empty_queue.append(filled_queue.popleft())
        elm = filled_queue[0]
        filled_queue.popleft()
        return elm

    def top(self) -> int:
        
        filled_queue = self.queue1 if self.queue1 else self.queue2
        empty_queue = self.queue1 if not self.queue1 else self.queue2

        size = len(filled_queue)

        for _ in range(size-1):
            empty_queue.append(filled_queue.popleft())
        top_elm = filled_queue.popleft()
        empty_queue.append(top_elm)
        return top_elm

    def empty(self) -> bool:

        return (not self.queue1) and (not self.queue2)        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()