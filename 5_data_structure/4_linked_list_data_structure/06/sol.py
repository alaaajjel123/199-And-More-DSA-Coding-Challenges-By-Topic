class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0
 
    def addAtTail(self, value):
        node = Node(value)
        if not self.head:
            self.head = node
            self.tail = self.head
        else:
            self.tail.next = node
            self.tail = node
        self.size += 1
        return self
 
def add2Numbers(l1, l2):
    # Time Complexity Explanation:
    # The while loop runs at most 'max(n, m)' times where 'n' and 'm' are the lengths of l1 and l2 respectively.
    # Thus, the time complexity is O(max(n, m)).
    
    carryForward = 0
    results = LinkedList()
    while l1 or l2 or carryForward:
        l1Value = l1.value if l1 else 0
        l2Value = l2.value if l2 else 0
        sum = (l1Value + l2Value + carryForward)
        nodeValueInResult = sum % 10
        results.addAtTail(nodeValueInResult)
        carryForward = sum // 10
        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None
    return results
 
# The time complexity of this function is O(max(n, m)) where n and m are the lengths of l1 and l2 respectively.

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0
 
    def addAtTail(self, value):
        node = Node(value)
        if not self.head:
            self.head = node
            self.tail = self.head
        else:
            self.tail.next = node
            self.tail = node
        self.size += 1
        return self
 
def add2Numbers(l1, l2):
    # Space Complexity Explanation:
    # We are creating a new LinkedList to store the sum.
    # The maximum possible length of this LinkedList is 'max(n, m) + 1' where 'n' and 'm' are the lengths of l1 and l2 respectively.
    # Therefore, the space complexity is O(max(n, m)).
 
    carryForward = 0
    results = LinkedList()
    while l1 or l2 or carryForward:
        l1Value = l1.value if l1 else 0
        l2Value = l2.value if l2 else 0
        sum = (l1Value + l2Value + carryForward)
        nodeValueInResult = sum % 10
        results.addAtTail(nodeValueInResult)
        carryForward = sum // 10
        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None
    return results