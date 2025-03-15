def knapSack(W, wt, val, n):

    def helper(index,rem_weight):
        if index > n-1 or rem_weight ==0:
            return 0
    
        exclude = helper (index+1, rem_weight)
        include = 0
        if wt [index]<=rem_weight:
            include = val [index] + helper(index+1, rem_weight-wt[index])
        return max(exclude, include)
    return helper (0,W)