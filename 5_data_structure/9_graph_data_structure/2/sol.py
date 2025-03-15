def trav_DFS_iterative(graph, start):
    # Initialize the output list, visited dictionary and stack
    output = []
    visited = {}
    stack = [start]
    
    # Mark the start node as visited
    visited[start] = True
    
    # While there are nodes in the stack
    while stack:
        # Pop a node from the stack
        current = stack.pop()
        
        # Append the current node to the output
        output.append(current)
        
        # Get all neighbours of the current node
        neighbours = graph[current]
        
        # For each neighbour
        for neighbour in neighbours:
            # If the neighbour has not been visited yet
            if neighbour not in visited:
                # Push the neighbour to the stack
                stack.append(neighbour)
                
                # Mark the neighbour as visited
                visited[neighbour] = True
    
    # Return the output list
    return output