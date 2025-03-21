def twoCitySchedCost(costs):
    def minCost(i, a_count):
        # Base cass
        if i == len(costs):
            return 0
 
        # Cost of sending the i-th person to City A
        if a_count < len(costs) // 2:
            costA = costs[i][0] + minCost(i + 1, a_count + 1)
        else:
            costA = float('inf')
        
        b_count = i - a_count 
        if b_count < len(costs) // 2:
            costB = costs[i][1] + minCost(i + 1, a_count)
        else:
            costB = float('inf') 
 
        # Return the minimum cost of the two choices
        return min(costA, costB)
 
    # Start the recursion from the 0-th index
    return minCost(0, 0)