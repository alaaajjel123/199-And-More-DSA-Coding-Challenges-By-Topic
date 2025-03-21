class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
# Creating the list
head = Node(1)
head.next = Node(2)
head.next.next = Node(3)
head.next.next.next = Node(4)
 
 
def reverseLinkedList(head):
    # Time Complexity Explanation: 
    # The function contains a while loop that traverses the linked list once, so the time complexity is O(n) 
    # where n is the number of nodes in the linked list.
    
    prev = None
    current = head
    while current:
        next = current.next
        current.next = prev
        prev = current
        current = next
    return prev
 
# The Time complexity of this function is O(n), where n is the number of nodes in the list.
 
reverseLinkedList(head)
Part 2-

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
# Creating the list
head = Node(1)
head.next = Node(2)
head.next.next = Node(3)
head.next.next.next = Node(4)
 
 
def reverseLinkedList(head):
    # Space Complexity Explanation: 
    # This function uses a constant amount of space to store the 'head', 'current', 'next', and 'prev' pointers. 
    # Therefore, the space complexity is O(1).
    
    prev = None
    current = head
    while current:
        next = current.next
        current.next = prev
        prev = current
        current = next
    return prev
 
# The Space complexity of this function is O(1), as it uses a constant amount of space
 
reverseLinkedList(head)