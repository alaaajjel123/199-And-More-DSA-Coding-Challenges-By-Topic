def solveNQueens(n):
    res = []
    board = [['.']*n for _ in range(n)]
    def convertBoard(board):
        return [''.join(row) for row in board]
    def isValid(row,col,board):
        for x in range(row):
            if board[x][col]=='Q': return False
        for r,c in zip(range(row,-1,-1),range(col,-1,-1)):
            if board[r][c] =='Q': return False 
        for r,c in zip(range(row,-1,-1),range(col,n,+1)):
            if board[r][c] =='Q': return False
        return True    
    def positionNextQueen(board,row): 
        if row ==n:
            res.append(convertBoard(board))   
            return 
        for col in range(n):
            if isValid(row,col,board):
                board[row][col]='Q'
                positionNextQueen(board,row+1)
                board[row][col] = '.'
    positionNextQueen(board,0)
    return res