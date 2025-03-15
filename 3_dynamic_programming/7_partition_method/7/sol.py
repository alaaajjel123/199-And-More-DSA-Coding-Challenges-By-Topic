def matrixMultiplication(N, arr):
    #Write code here
    dp = [[-1]*N for _ in range(N)]
    def findCost(i,j):
        #base
        if i==j: return 0 
        #rec
        if dp[i][j] !=-1 : return dp[i][j]
        cost = float ('inf')
        for k in range(i, j):
            curr_cost = findCost (i,k) + findCost(k+1, j) + arr[i-1]*arr[k]*arr[j]
            cost = min (cost, curr_cost)
        dp[i][j] = cost
        return dp[i][j]
    return findCost (1,N-1)