def knapSack(N, W, val, wt):
    # code here
    dp = [[-1]*(W+1) for _ in range(N+1)]
    
    for j in range(W+1):
        dp[0][j] = 0
    
    for i in range(N+1):
        dp[i][0] = 0
    
    for i in range(1,N+1):
        for j in range(1,W+1):
            exclude = dp[i-1][j]
            include = 0
            if wt[i-1] <=j:
                include = val[i-1] + dp[i][j -wt[i-1]]
            dp[i][j] = max(exclude,include)
    return dp[N][W]