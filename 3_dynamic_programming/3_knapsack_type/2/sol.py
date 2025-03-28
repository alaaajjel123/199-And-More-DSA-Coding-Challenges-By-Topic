def knapSack(W, wt, val, n):
    dp = [[-1]* (W+1) for _ in range(n)]
    def helper(index, rem_weight):

        if index > n-1 or rem_weight ==0:
            return 0
        if dp[index][rem_weight]!=-1:
            return dp[index][rem_weight]
        exclude = helper(index+1, rem_weight)
        include = 0
        if wt[index]<=rem_weight:
            include = val[index] + helper(index+1, rem_weight-wt[index])
        dp[index][rem_weight]= max(exclude, include) #storing 
        return dp[index][rem_weight]
    return helper(0,W)