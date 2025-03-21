class Node:
    def __init__(self, value):
        self.val = value
        self.next = None
        self.prev = None
 
def linkNodes(node1, node2):
    node1.next = node2
    node2.prev = node1
 
class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
 
    def remove(self, node):
        # Space complexity Explanation: 
        # No additional space is used when removing a node from the linked list. 
        # Only the existing pointers are rearranged. 
        # Hence the space complexity is O(1)
 
        if self.head == node:
            self.head = node.next
        if self.tail == node:
            self.tail = node.prev
 
        if node.prev:
            node.prev.next = node.next
        if node.next:
            node.next.prev = node.prev
 
        node.next = None
        node.prev = None
 
    def insertB(self, nodePosition, nodeInsert):
        # Space complexity Explanation: 
        # No additional space is used when inserting a node in the linked list. 
        # Only the existing pointers are rearranged. 
        # Hence the space complexity is O(1)
 
        if self.head == nodeInsert and self.tail == nodeInsert:
            return
        self.remove(nodeInsert)
 
        nodeInsert.prev = nodePosition.prev
        nodeInsert.next = nodePosition
 
        if nodePosition == self.head:
            self.head = nodeInsert
        else:
            nodePosition.prev.next = nodeInsert
        nodePosition.prev = nodeInsert
 
    def allNodesValueRemove(self, value):
        # Space complexity Explanation:
        # No additional space is used when removing nodes based on the value. 
        # Hence the space complexity is O(1).
 
        curr = self.head
        while curr:
            temp = curr
            curr = curr.next
            if temp.val == value:
                self.remove(temp)