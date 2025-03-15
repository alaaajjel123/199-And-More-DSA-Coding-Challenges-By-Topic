def subsetsWithDup(nums):
    res = []
    nums.sort()
    def subsets(index,curr):
        if index ==len(nums):
            res.append(curr[:])
            return
        #include
        curr.append(nums[index])
        subsets(index+1,curr)
        curr.pop()    
        #exclude
        while index<len(nums)-1 and nums[index]==nums[index+1]:
            index+=1
        subsets(index+1,curr) 
    subsets(0,[])
    return res                   