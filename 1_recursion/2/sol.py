def findTheWinner(n, k):
    #write code here
    arr = [i+1 for i in range(n)]
    def helper(arr, start_index):
        #base case 
        if len(arr)==1:
            return arr[0]
        index_to_remove = (start_index + k - 1) % len(arr)
        del arr[index_to_remove]
        return helper(arr, index_to_remove)
    return helper(arr,0)  