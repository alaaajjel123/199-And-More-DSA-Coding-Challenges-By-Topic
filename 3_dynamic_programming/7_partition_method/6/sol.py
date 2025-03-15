def matrixMultiplication(N, arr):
    #Write code here 
    def findCost(i ,j):
        #base
        if i==j: return 0 #recur
        cost = float ('inf')
        for k in range(i,j):
            curr_cost = findCost(i,k) + findCost(k+1,j) + arr[i-1]*arr[k]*arr[j]
            cost = min (cost, curr_cost)
        return cost
    return findCost (1,N-1)