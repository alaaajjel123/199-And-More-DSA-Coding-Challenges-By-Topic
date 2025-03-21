def permute(nums):
    res = []
    n = len(nums)
    def helper(i):
        if i==n-1:
            res.append(nums[:])
            return
        for j in range(i,n):
            nums[i],nums[j] = nums[j],nums[i]
            helper(i+1)
            nums[i],nums[j] = nums[j], nums[i]    
    helper(0)
    return res  