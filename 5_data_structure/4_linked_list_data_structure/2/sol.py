class Node:
    def __init__(self, value):
        self.val = value
        self.next = None
 
# Creating the list
head = Node(1)
head.next = Node(2)
head.next.next = Node(2)
head.next.next.next = Node(3)
head.next.next.next.next = Node('a')
head.next.next.next.next.next = Node('a')
 
 
def removeDupes(head):
    
    curr = head
    while curr:
        nextDistinctVal = curr.next
        while nextDistinctVal is not None and curr.val == nextDistinctVal.val:
            nextDistinctVal = nextDistinctVal.next
        curr.next = nextDistinctVal
        curr = nextDistinctVal
    return head

 
removeDupes(head)
Part 2-

class Node:
    def __init__(self, value):
        self.val = value
        self.next = None
 
# Creating the list
head = Node(1)
head.next = Node(2)
head.next.next = Node(2)
head.next.next.next = Node(3)
head.next.next.next.next = Node('a')
head.next.next.next.next.next = Node('a')
 
 
def removeDupes(head):
    
    curr = head
    while curr:
        nextDistinctVal = curr.next
        while nextDistinctVal is not None and curr.val == nextDistinctVal.val:
            nextDistinctVal = nextDistinctVal.next
        curr.next = nextDistinctVal
        curr = nextDistinctVal
    return head

removeDupes(head)