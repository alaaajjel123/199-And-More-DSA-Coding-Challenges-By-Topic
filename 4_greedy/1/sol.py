def fractionalknapsack(W, arr, n):
    # write code here

    arr.sort(reverse=True, key=lambda x: x[0] / x[1])
    
    remaining_weight = W
    value = 0
    n = len(arr)
    
    for i in range(n):
        if remaining_weight == 0:
            break
        
        weight = min(remaining_weight, arr[i][1])
        remaining_weight -= weight
        value += arr[i][0] / arr[i][1] * weight
    
    return value
