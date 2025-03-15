def rev_pol_not(tokens):
    
    stack = []
    valid_operator = {
        '+': lambda n1, n2: n1 + n2,
        '-': lambda n1, n2: n1 - n2,
        '*': lambda n1, n2: n1 * n2,
        '/': lambda n1, n2: int(n1 / n2)
    }
 
    for token in tokens:
        if token in valid_operator:
            n2 = stack.pop()
            n1 = stack.pop()
            result = valid_operator[token](n1, n2)
            stack.append(result)
        else:
            stack.append(int(token))
 
    return stack.pop()
