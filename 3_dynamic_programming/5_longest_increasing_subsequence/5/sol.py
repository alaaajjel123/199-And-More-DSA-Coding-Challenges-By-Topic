def maxEnvelopes(envelopes):
    envelopes.sort(key = lambda x:(x[0],-x[1]))

    n = len(envelopes)
    sub = [envelopes[0][1]]

    def binary_search(sub,num):
        left, right = 0,len(sub)
        while left<right:
            mid = (left+right)//2
            if num>sub[mid]:
                left = mid+1
            else:
                right = mid
        return left

    for i in range(1,n):
        num = envelopes[i][1]
        if num>sub[-1]:
            sub.append(num)
        else:
            x = binary_search(sub,num)
            sub[x]=num
    return len(sub)                