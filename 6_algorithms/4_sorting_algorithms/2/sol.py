def insertion_sort(array):
    for i in range(1,len(array)):
        j = i-1
        temp = array[i]
        while j>=0 and array[j]>temp:
            array[j+1] = array[j]
            j -=1
        array[j+1] = temp
    return array


print(insertion_sort([5,4,3,2,1]))