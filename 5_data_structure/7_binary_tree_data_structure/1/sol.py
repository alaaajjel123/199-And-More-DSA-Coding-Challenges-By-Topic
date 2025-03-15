class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
 
 
class BinarySearchTree:
    def __init__(self):
        self.root = None
 
    def insert(self, value):
        node = Node(value)
        if not self.root:
            self.root = node
            return self
        tree = self.root
        while True:
            if value < tree.value:
                if not tree.left:
                    tree.left = node
                    return self
                tree = tree.left
            else:
                if not tree.right:
                    tree.right = node
                    return self
                tree = tree.right
 
    def find(self, value):
        if not self.root:
            return False
        tree = self.root
        while tree:
            if value < tree.value:
                tree = tree.left
            elif value > tree.value:
                tree = tree.right
            elif value == tree.value:
                return tree
        return False
 
    def remove(self, value, current=None, parent=None):
        if not self.root:
            return False
        if not current:
            current = self.root
        while current:
            if value < current.value:
                parent = current
                current = current.left
            elif value > current.value:
                parent = current
                current = current.right
            else:
                if current.left and current.right:
                    current.value = self.get_min(current.right)
                    self.remove(current.value, current.right, current)
                elif parent is None:
                    if current.left:
                        current.value = current.left.value
                        current.right = current.left.right
                        current.left = current.left.left
                    elif current.right:
                        current.value = current.right.value
                        current.right = current.right.right
                        current.left = current.right.left
                    else:
                        self.root = None
                elif current == parent.left:
                    parent.left = current.left if current.left else current.right
                elif current == parent.right:
                    parent.right = current.left if current.left else current.right
                break
        return self
 
    def get_min(self, node):
        while node.left:
            node = node.left
        return node.value