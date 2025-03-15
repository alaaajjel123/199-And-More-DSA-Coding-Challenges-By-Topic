def merge_sorted_arrays(array1, array2):
    merged_array = []
    i, j = 0, 0
    # This loop runs a maximum of min(len(array1), len(array2)) times.
    # So, its time complexity contributes to O(n), where n is the minimum size between array1 and array2.
    while i < len(array1) and j < len(array2):
        if array1[i] <= array2[j]:
            merged_array.append(array1[i])
            i += 1
        else:
            merged_array.append(array2[j])
            j += 1
    
    # These loops run a maximum of len(array1) - i and len(array2) - j times, respectively.
    # They will only execute if all elements of the other array have been appended to merged_array.
    # Each contributes to O(n) as well, where n is the remaining elements in array1 or array2.
    while i < len(array1):
        merged_array.append(array1[i])
        i += 1
    while j < len(array2):
        merged_array.append(array2[j])
        j += 1
 
    return merged_array
 
def merge_sort(array):
    # A single or empty array is already sorted, so return as is.
    # This acts as the base condition for this recursive function.
    if len(array) <= 1:
        return array
    
    middle = len(array) // 2
    left_side = merge_sort(array[:middle])
    right_side = merge_sort(array[middle:])
 
    # Here, merge_sort() is called recursively, which gives this function a time complexity of O(log n).
    # Because for each recursive call, the array is divided into two halves.
    # Hence, we can say the time complexity of merge_sort() is O(n log n) due to each level taking O(n) time
    # and there being log(n) levels as the array is divided into two halves at each level.
    return merge_sorted_arrays(left_side, right_side)