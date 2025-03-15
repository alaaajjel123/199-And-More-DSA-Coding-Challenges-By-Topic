def lengthOfLIS(nums):
    n = len(nums)
    def helper(curr,prev):
        if curr >n-1:
            return 0
        exclude = helper(curr+1,prev)    
        include = 0    
        if prev ==-1 or nums[curr] > nums[prev]:
            include = 1 + helper(curr+1,curr)   
        return max(include,exclude)     
    return helper(0,-1)    