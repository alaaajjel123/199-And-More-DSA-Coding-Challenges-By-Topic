def permuteUnique(nums):
    res = []
    def permutations(index):
        if index == len(nums)-1:
            res.append(nums[:])
            return
        hash = {}    
        for j in range(index,len(nums)):
            if nums[j] not in hash:
                hash[nums[j]]=1
                nums[index],nums[j] = nums[j],nums[index]
                permutations(index+1)
                nums[index],nums[j] = nums[j],nums[index]
    permutations(0)            
    return res