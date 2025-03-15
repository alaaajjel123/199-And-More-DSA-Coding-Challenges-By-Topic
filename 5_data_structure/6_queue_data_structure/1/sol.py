class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
class QueueLinkedList:
    def __init__(self):
        self.first = None
        self.last = None
        self.size = 0
 
    def enqueue(self, value):
        # Time Complexity Explanation:
        # Creating a new node and updating the last pointer has a time complexity of O(1)
        node = Node(value)
        if not self.first:
            self.first = node
            self.last = node
        else:
            self.last.next = node
            self.last = node
        self.size += 1
 
    def dequeue(self):
        # Time Complexity Explanation:
        # Updating the first pointer and reducing the size variable has a time complexity of O(1)
        if not self.first:
            return None
        temp = self.first
        self.first = self.first.next
        self.size -= 1
        if self.size == 0:
            self.last = None
        return temp.value
