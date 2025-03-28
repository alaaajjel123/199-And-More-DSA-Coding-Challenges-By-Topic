def minDistance(word1, word2):
    n = len(word1)
    m = len(word2)
    def number_of_operations(index1,index2):

        if index1>n-1 and index2>m-1:
            return 0
        if index1>n-1:
            return m-index2
        if index2>m-1:
            return n - index1        

        if word1[index1]==word2[index2]:
            return number_of_operations(index1+1,index2+1)
        insert = 1 + number_of_operations(index1,index2+1)
        delete = 1 + number_of_operations(index1+1,index2)
        replace = 1 + number_of_operations(index1+1,index2+1)
        return min(insert,delete,replace)    
    return number_of_operations(0,0)    