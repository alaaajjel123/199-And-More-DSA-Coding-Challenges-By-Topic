def non_repeating_char(str):
    ht = {}
    for i in str:
        if i in ht:
            ht[i]+=1
        else:
            ht[i] = 1
    for i in range(len(str)):
        if ht[str[i]] == 1:
            return i
    return None
