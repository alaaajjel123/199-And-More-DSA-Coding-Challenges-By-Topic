def longestPalindromeSubseq(s):
    rev_s = s[::-1]
    n = len(s)

    dp=[[-1]*(n+1) for _ in range(n+1)]
    for i in range(n+1):
        dp[i][0]=0
        dp[0][i]=0

    for i in range(1,n+1):
        for j in range(1,n+1):
            if s[i-1]==rev_s[j-1]:
                dp[i][j]=1+dp[i-1][j-1]
            else:
                dp[i][j]=max(dp[i][j-1],dp[i-1][j])
    return dp[n][n]                  