def binary_search_iterative(array,target):
    left = 0
    right = len(array)-1
    while left <=right :
        middle = (left + right)//2
        if array[middle] == target:
            return middle
        elif array[middle] < target:
            left = middle + 1
        else:
            right = middle - 1
    return -1

print(binary_search_iterative([2,3,7,9,11,23,37,81,87,89],87))