def climbStairs(n):
    if n<=2: return n
    def helper(first,second,n,curr):
        next = first + second
        if curr==n: return next
        return helper(second,next,n,curr+1)
    return helper(1,2,n,3)