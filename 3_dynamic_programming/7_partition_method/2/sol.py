def minCut(s):
    def isPalindrome(start,end):
        while start<end:
            if s[start]!=s[end]:
                return False
            start+=1
            end-=1
        return True
    def partitions(start,end):

        if start ==end or isPalindrome(start,end):
            return 0
        minimumCuts = end - start    
        for endIndex in range(start,end):
            if isPalindrome(start,endIndex):
                minimumCuts = min(minimumCuts,1+partitions(endIndex+1,end))
        return minimumCuts    
    return partitions(0,len(s)-1)    