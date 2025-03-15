def minCostClimbingStairs(cost):
    n = len(cost)
    def helper(index):
        if index >=n :return 0
        one = cost[index] + helper(index+1)
        two = cost[index]+ helper(index+2)
        return min(one,two)

    return min(helper(0),helper(1))    