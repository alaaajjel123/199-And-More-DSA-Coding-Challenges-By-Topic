# Space complexity: O(n), as we are creating an adjacency list and in-degree list of n elements each
def helper(n, prerecs):
    adjList = [[] for _ in range(n)]
    inDegree = [0 for _ in range(n)]
    for prerec in prerecs:
        toTake, firstTake = prerec
        adjList[firstTake].append(toTake)
        inDegree[toTake] += 1
    return [adjList, inDegree]
# Final space complexity of helper: O(n + E), as the adjacency list can hold up to E edges and n vertices
 
# Space complexity: O(n), as the maximum possible size of stack is n
def checkIfCanFinish(n, prerecs):
    stack = []
    adjList, inDegree = helper(n,prerecs)
    for i in range(n):
        if inDegree[i] == 0:
            stack.append(i)
    count = 0
    while stack:
        current = stack.pop()
        count += 1
        neighbours = adjList[current]
        for i in range(len(neighbours)):
            neighbour = neighbours[i]
            inDegree[neighbour] -= 1
            if inDegree[neighbour] == 0:
                stack.append(neighbour)
    return count == n
# Final space complexity of checkIfCanFinish: O(n + E), 
# This includes space for adjacency list, in-degree list and the stack.