def minCostClimbingStairs(cost):
    n = len(cost)
    array = [-1]*n
    def helper(index):
        if index >=n :return 0
        if array[index]!=-1:
            return array[index]
        one = cost[index] + helper(index+1)
        two = cost[index]+ helper(index+2)
        array[index]=min(one,two)
        return array[index]

    return min(helper(0),helper(1))    