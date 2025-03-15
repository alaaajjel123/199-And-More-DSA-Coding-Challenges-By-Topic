def invertRecursive(node):
    if node is None:  # Check if node is null (Space Complexity: O(1))
        return
 
    # Swap the nodes (Space Complexity: O(1))
    temp = node.left
    node.left = node.right
    node.right = temp
 
    # Perform the same operations for the left and right child nodes
    invertRecursive(node.left)  # Recursive call (Space Complexity: O(h/2))
    invertRecursive(node.right)  # Recursive call (Space Complexity: O(h/2))
 
    # The overall Space Complexity of the function is O(h), where h is
    # the height of the binary tree. This is because in a recursive function,
    # space is required to store the recursive call stack. The deepest
    # the recursion can go is till the height of the tree.
    return node