def minCostClimbingStairs(cost):
    n = len(cost)
    arr = [-1]*(n+1)
    arr[0]=0
    arr[1]=0
    for i in range(2,n+1):
        prevOne = cost[i-1]+ arr[i-1]
        prevTwo = cost[i-2]+arr[i-2]
        arr[i] = min(prevOne,prevTwo)
    return arr[n]    