def can_jump_from_position(position, nums):
    if position == len(nums) - 1:
        return True
 
    furthest_jump = min(position + nums[position], len(nums) - 1)
    for next_position in range(position + 1, furthest_jump + 1):
        if can_jump_from_position(next_position, nums):
            return True
 
    return False
 
def can_jump(nums):
    return can_jump_from_position(0, nums)