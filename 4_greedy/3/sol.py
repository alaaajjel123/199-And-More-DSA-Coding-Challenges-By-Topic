def canJump(nums):
    # Initialize the memoization table with None values
    memo = [None] * len(nums)
    memo[-1] = True  # The last index is always reachable from itself
    
    def canJumpFromPosition(position):
        if memo[position] is not None:
            # If we have already computed the value, return it
            return memo[position]
 
        # Compute the furthest jump from the current position
        furthestJump = min(position + nums[position], len(nums) - 1)
        
        # Check if any position reachable from here can reach the end
        for nextPosition in range(position + 1, furthestJump + 1):
            if canJumpFromPosition(nextPosition):
                memo[position] = True
                return True
 
        memo[position] = False
        return False
 
    # Start the recursive check from the first index
    return canJumpFromPosition(0)