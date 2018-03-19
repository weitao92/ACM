#https://pcs.cs.cloud.vt.edu/problems/199
[w,h] = map(int, input().split())
maze = [[0 for i in range(w)] for j in range(h)]
golds = [[0 for i in range(w)] for j in range(h)]
world = []

class point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def inRange(x, y):
    return x >= 0 and x < h and y >= 0 and y < w and maze[x][y] != -1

for i in range(h):
    line = input()
    world.append(line + "\n")
    for j in range(w):
        c = line[j:j+1]
        if c == 'P':
            start = point(i,j)
            if maze[i][j] != -2:
                maze[i][j] = 2
        elif c == 'G':
            golds[i][j] = 1
            if maze[i][j] != -2:
                maze[i][j] = 1
        elif c == 'T':
            maze[i][j] = -1
            if inRange(i,j-1):
                maze[i][j-1] = -2
            if inRange(i-1,j):
                maze[i-1][j] = -2
            if inRange(i,j+1):
                maze[i][j+1] = -2
            if inRange(i+1,j):
                maze[i+1][j] = -2
        elif c == '#':
            maze[i][j] = -1
        else:
            if maze[i][j] != -2:
                maze[i][j] = 0

visited = [[False for i in range(w)] for j in range(h)]

queue = [start]
visited[start.x][start.y] = True
result = 0

while len(queue) != 0:
    current = queue.pop(0)
    if golds[current.x][current.y] == 1:
        #print(str(current.x) + " " + str(current.y))
        result += 1
    if maze[current.x][current.y] == -2:
        continue
    else:
        if inRange(current.x, current.y-1) and visited[current.x][current.y-1] == False:
            visited[current.x][current.y-1] = True;
            queue.append(point(current.x,current.y-1))
        if inRange(current.x-1, current.y) and visited[current.x-1][current.y] == False:
            visited[current.x-1][current.y] = True;
            queue.append(point(current.x-1,current.y))
        if inRange(current.x, current.y+1) and visited[current.x][current.y+1] == False:
            visited[current.x][current.y+1] = True;
            queue.append(point(current.x,current.y+1))
        if inRange(current.x+1, current.y) and visited[current.x+1][current.y] == False:
            visited[current.x+1][current.y] = True;
            queue.append(point(current.x+1,current.y))
print(result)


            


