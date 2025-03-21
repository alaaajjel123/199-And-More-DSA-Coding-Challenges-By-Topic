def getDuplicate(nums):
    # Time Complexity Explanation:
    # The while loop runs at most 'n' times where 'n' is the number of elements in the array.
    # Thus, the time complexity is O(n).
    
    hare = 0
    tortoise = 0
 
    while True:
        hare = nums[nums[hare]]
        tortoise = nums[tortoise]
 
        if hare == tortoise:
            pointer = 0
            while pointer != tortoise:
                pointer = nums[pointer]
                tortoise = nums[tortoise]
            return pointer
 
# The time complexity of this function is O(n) where n is the number of elements in the array

def getDuplicate(nums):
    # Space Complexity Explanation:
    # We only use a constant amount of memory to store variables 'hare', 'tortoise', and 'pointer'.
    # Therefore, the space complexity is O(1).
 
    hare = 0
    tortoise = 0
 
    while True:
        hare = nums[nums[hare]]
        tortoise = nums[tortoise]
 
        if hare == tortoise:
            pointer = 0
            while pointer != tortoise:
                pointer = nums[pointer]
                tortoise = nums[tortoise]
            return pointer
 
# The space complexity of this function is O(1) as it uses a constant amount of space