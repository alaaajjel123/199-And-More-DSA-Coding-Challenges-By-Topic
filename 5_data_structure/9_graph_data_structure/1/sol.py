def travBFS(graph, start):
    visited = {}
    queue = [start]
    output = []
    visited[start] = True
 
    while len(queue) > 0:
        current = queue.pop(0)
        output.append(current)
        current_idx = vertex_indices[current]
 
        neighbours = graph[current_idx]
        for i in range(len(neighbours)):
            if neighbours[i] == 1 and vertices[i] not in visited:
                queue.append(vertices[i])
                visited[vertices[i]] = True
 
    return output