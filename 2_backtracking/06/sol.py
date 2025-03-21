def combinationSum(candidates, target):
    res = []
    def combinationSum(index,curr,currSum):
        if currSum>target:
            return
        if currSum ==target:
            res.append(curr[:])
            return
        for j in range(index,len(candidates)):
            curr.append(candidates[j])   
            combinationSum(j,curr,currSum+candidates[j])
            curr.pop()
    combinationSum(0,[],0)
    return res         