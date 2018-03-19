#https://pcs.cs.cloud.vt.edu/contests/36/problems/A
class point:
    def __init__(self, row, col):
        self.row = row
        self.col = col
def in_range(n, p):
    return p.row >= 0 and p.row < n and p.col >= 0 and p.col < n
def valid(board, n, row, col):
    for i in range(n):
        if i != col:
            if board[row][i] == 1:
                return False
    for i in range(n):
        if i != row:
            if board[i][col] == 1:
                return False
    x1 = point(row-1,col-1)
    while in_range(n,x1):
        if board[x1.row][x1.col] == 1:
            return False
        x1.row -= 1
        x1.col -= 1
    x2 = point(row-1,col+1)
    while in_range(n,x2):
        if board[x2.row][x2.col] == 1:
            return False
        x2.row -= 1
        x2.col += 1
    x3 = point(row+1,col+1)
    while in_range(n,x3):
        if board[x3.row][x3.col] == 1:
            return False
        x3.row += 1
        x3.col += 1
    x4 = point(row+1,col-1)
    while in_range(n,x4):
        if board[x4.row][x4.col] == 1:
            return False
        x4.row += 1
        x4.col -= 1
    return True

n = int(input())
board = [[0 for i in range(n)] for j in range(n)]
finished = False

def backtrack(board, col):
    global finished
    if finished:
        return
    for row in range(n):
        if valid(board,n,row,col):
            board[row][col] = 1
            if col == n-1:
                finished = True
            backtrack(board, col+1)
            if finished:
                return
            else:
                board[row][col] = 0
                
backtrack(board, 0)
for i in range(n):
    temp = ""
    for j in range(n):
        if board[i][j] == 0:
            temp += "."
        else:
            temp += "x"
    print(temp)