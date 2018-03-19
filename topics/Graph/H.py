#https://pcs.cs.cloud.vt.edu/contests/44/problems/E
class point:
    def __init__(self, row, col):
        self.row = row
        self.col = col

def border(point, n, m):
    if point.row == 0 or point.row == n-1 or point.col == 0 or point.col == m-1:
        return True
    else:
        return False

def in_range(point, n, m):
    return point.row >= 0 and point.row < n and point.col >= 0 and point.col < m

[n,m,k] = map(int, input().split())
world = [[0 for i in range(m)] for j in range(n)]
visited = [[False for i in range(m)] for j in range(n)]
for i in range(n):
    line = input()
    for j in range(m):
        c = line[j:j+1]
        if c == '.':
            world[i][j] = 1
lakes = []
for i in range(n):
    for j in range(m):
        if world[i][j] == 1 and visited[i][j] == False:
            isLake = True
            lake = 0
            queue = []
            queue.append(point(i,j))
            while len(queue) != 0:
                lake += 1
                current = queue.pop(0)
                if border(current,n,m):
                    isLake = False
                visited[current.row][current.col] = True
                p1 = point(current.row-1,current.col)
                if in_range(p1,n,m) and world[p1.row][p1.col] == 1 and visited[p1.row][p1.col] == False:
                    visited[p1.row][p1.col] = True
                    queue.append(p1)
                p2 = point(current.row,current.col+1)
                if in_range(p2,n,m) and world[p2.row][p2.col] == 1 and visited[p2.row][p2.col] == False:
                    visited[p2.row][p2.col] = True
                    queue.append(p2)
                p3 = point(current.row+1,current.col)
                if in_range(p3,n,m) and world[p3.row][p3.col] == 1 and visited[p3.row][p3.col] == False:
                    visited[p3.row][p3.col] = True
                    queue.append(p3)
                p4 = point(current.row,current.col-1)
                if in_range(p4,n,m) and world[p4.row][p4.col] == 1 and visited[p4.row][p4.col] == False:
                    visited[p4.row][p4.col] = True
                    queue.append(p4)
            if isLake:
                lakes.append(lake)

lakes.sort()
result = 0
num = len(lakes)
for i in range(num - k):
    result += lakes.pop(0)
print(result)