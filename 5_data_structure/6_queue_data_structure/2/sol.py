class MyQueue:
 
    def __init__(self):
        self.inStack = []
        self.outStack = []
 
    def push(self, val):
        # Time complexity is O(1) as we are simply adding an element to the stack.
        self.inStack.append(val)
 
    def pop(self):
        # Time complexity is amortized O(1) because in the worst case we will move all elements from inStack to outStack
        # But this happens only when outStack is empty, and after this operation next several pop operations will take O(1) time.
        # Therefore, for n pop operations, overall time will be O(n), making it amortized O(1).
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()
 
    def peek(self):
        # Similar to the pop operation, the time complexity is amortized O(1).
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
 
    def empty(self):
        # Time complexity is O(1) as we are simply checking the length of the stacks.
        return len(self.inStack) == 0 and len(self.outStack) == 0