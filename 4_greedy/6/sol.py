def twoCitySchedCost(costs):
    n = len(costs) // 2
    memo = {}
 
    def minCost(i, a_count):
        if i == len(costs):
            return 0 
        if (i, a_count) in memo:
            return memo[(i, a_count)]
        
        # Cost of sending the i m person to A
        costA = costs[i][0] + minCost(i + 1, a_count + 1) if a_count < n else float('inf')
        # Cost of sending the i m person to B
        costB = costs[i][1] + minCost(i + 1, a_count) if (i - a_count) < n else float('inf')
        
        # Store the result in memo dict
        memo[(i, a_count)] = min(costA, costB)
        return memo[(i, a_count)]
 
    # Start the recursion from the 0-th index
    return minCost(0, 0)