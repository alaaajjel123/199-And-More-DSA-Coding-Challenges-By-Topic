def solveSudoku(board):

    def isValid(board, row, col, num):
        for x in range(9):
            if board[x][col] == num or board[row][x] == num:
                return False

            r = 3 * (row // 3) + x // 3
            c = 3 * (col // 3) + x % 3

            if board[r][c] == num:
                return False

        return True

    def helper(board):
        for row in range(9):
            for col in range(9):
                if board[row][col] == '.':
                    for num in '123456789':
                        if isValid(board, row, col, num):
                            board[row][col] = num

                            if helper(board):
                                return True

                            board[row][col] = '.'

                    return False

        return True

    helper(board)
