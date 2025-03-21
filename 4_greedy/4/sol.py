def can_jump(nums):
    n = len(nums)
    # Create a DP table, initialized to False except the first element
    dp = [False] * n
    dp[0] = True  # Start is always reachable from itself
 
    # Fill the DP table from left to right
    for i in range(n):
        if dp[i]:  # If current index is reachable
            # Calculate the furthest we can reach from here
            furthest = min(i + nums[i], n - 1)
            # Mark all reachable positions as True
            for j in range(i + 1, furthest + 1):
                dp[j] = True
 
    # If the last position is True, then it's reachable
    return dp[-1]
