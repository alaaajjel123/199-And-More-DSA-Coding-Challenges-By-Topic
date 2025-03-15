class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
class StackLinkedList:
    def __init__(self):
        # Space Complexity Explanation:
        # The auxiliary space complexity of a stack implemented using a linked list is O(1), 
        # because we are not using any extra data structures that scale with the input size. 
        # We only have a few variables to maintain the state of the stack.
        self.first = None
        self.last = None
        self.size = 0
 
    def addAtBeginning(self, value):
        node = Node(value)
        if not self.first:
            self.first = node
            self.last = node
        else:
            temp = self.first
            self.first = node
            self.first.next = temp
        self.size += 1
        return self
 
    def removeFromBeginning(self):
        if not self.first:
            return None
        temp = self.first
        self.first = self.first.next
        self.size -= 1
        if self.size == 0:
            self.last = None
        return temp.value