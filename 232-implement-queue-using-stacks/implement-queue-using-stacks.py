class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        size = len(self.stack1)
        for _ in range(size-1):
            self.stack2.append(self.stack1.pop())
        popped_elm = self.stack1.pop()
        
        for _ in range(size-1):
            self.stack1.append(self.stack2.pop())
        return popped_elm

    def peek(self) -> int:
        size = len(self.stack1)
        for _ in range(size-1):
            self.stack2.append(self.stack1.pop())
        peek = self.stack1.pop()
        self.stack1.append(peek)
        for _ in range(size-1):
            self.stack1.append(self.stack2.pop())
        return peek

    def empty(self) -> bool:
        return len(self.stack1) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()