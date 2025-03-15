def selection_sort(nums):
    # The outer loop runs n times, where n is the length of the list.
    # This contributes to the O(n) part of the time complexity.
    for i in range(len(nums)):
        smallest = i
 
        # The inner loop runs (n - i) times, i is the current iteration of the outer loop.
        # As i increases, the number of times the inner loop runs decreases.
        # Therefore, this loop runs roughly (n*(n-1))/2 times, which simplifies to O(n^2)
        for j in range(i+1, len(nums)):
            if nums[j] < nums[smallest]:
                smallest = j
 
        # The swap operation is performed in constant time O(1), 
        # but it's nested in a loop, so in the worst case it could be performed n times.
        # However, since it's not contributing more than the inner loop, 
        # it's not taken into account in the final time complexity.
        if i != smallest:
            nums[i], nums[smallest] = nums[smallest], nums[i]
    return nums