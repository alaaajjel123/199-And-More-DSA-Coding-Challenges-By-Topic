def combine(n,k):
    res = []
    def helper(start,curr):
        if len(curr)==k:
            res.append(curr[:])
            return
        for j in range(start,n+1):
            curr.append(j)
            helper(j+1,curr)
            curr.pop()
    helper(1,[])
    return res        