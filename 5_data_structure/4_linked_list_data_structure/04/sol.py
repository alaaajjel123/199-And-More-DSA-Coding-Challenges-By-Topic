class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
def checkLoop(head):
    # Time Complexity Explanation:
    # The while loop runs at most 'n' times where 'n' is the number of elements in the linked list. 
    # Thus, the time complexity is O(n).
    
    if not head or not head.next:
        return None
 
    hare = head
    tortoise = head
    while hare and hare.next:
        hare = hare.next.next
        tortoise = tortoise.next
        if hare == tortoise:
            break
 
    if hare != tortoise:
        return None
 
    # find where cycle begins
    pointer = head
    while pointer != tortoise:
        pointer = pointer.next
        tortoise = tortoise.next
 
    return tortoise
 
# The time complexity of this function is O(n) where n is the number of nodes in the list
Part 2-

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
 
def checkLoop(head):
    # Space Complexity Explanation:
    # We only use a constant amount of memory to store pointers 'head', 'hare', 'tortoise', and 'pointer'. 
    # Therefore, the space complexity is O(1).
    
    if not head or not head.next:
        return None
 
    hare = head
    tortoise = head
    while hare and hare.next:
        hare = hare.next.next
        tortoise = tortoise.next
        if hare == tortoise:
            break
 
    if hare != tortoise:
        return None
 
    # find where cycle begins
    pointer = head
    while pointer != tortoise:
        pointer = pointer.next
        tortoise = tortoise.next
 
    return tortoise
 
# The space complexity of this function is O(1) as it uses a constant amount of space
For Testing it yourself -

# For Testing
one = Node(1)
two = Node(2)
three = Node(3)
four = Node(4)
five = Node(5)
six = Node(6)
 
one.next = two
two.next = three
three.next = four
four.next = five
five.next = six
# make a loop
six.next = three
 
head = one
 
print(checkLoop(head).value)