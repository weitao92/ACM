#https://pcs.cs.cloud.vt.edu/contests/44/problems/D
class point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

class cell:
    def __init__(self, point, min):
        self.point = point
        self.min = min

def not_visited(visited, p):
    rows = len(visited)
    x = p.x
    y = rows-1-p.y
    return visited[y][x] == False

def set_visited(visited, p):
    rows = len(visited)
    x = p.x
    y = rows-1-p.y
    visited[y][x] = True
    
def in_range(house, p):
    rows = len(house)
    cols = len(house[0])
    x = p.x
    y = rows-1-p.y
    return x >= 0 and x < cols and y >= 0 and y < rows and house[y][x] != -1

def handle_wall(house, p1, p2):
    rows = len(house)
    x1 = p1.x
    x2 = p2.x
    y1 = rows-1-p1.y
    y2 = rows-1-p2.y
    if x1 == x2:
        if y1 >= y2:
            for i in range(y2,y1+1):
                house[i][x1] = -1
        else:
            for i in range(y1,y2+1):
                house[i][x1] = -1
    elif y1 == y2:
        if x1 >= x2:
            for i in range(x2,x1+1):
                house[y1][i] = -1
        else:
            for i in range(x1,x2+1):
                house[y1][i] = -1
    else:
        if y2 < y1 and x2 < x1:
            y = y2
            for i in range(x2,x1+1):
                house[y][i] = -1
                y += 1

        elif y2 < y1 and x2 > x1:
            y = y1
            for i in range(x1,x2+1):
                house[y][i] = -1
                y -= 1
        elif y2 > y1 and x2 > x1:
            y = y1
            for i in range(x1,x2+1):
                house[y][i] = -1
                y += 1
        else:
            y = y2
            for i in range(x2,x1+1):
                house[y][i] = -1
                y -= 1

raw = []
while True:
    temp = input().split()
    if len(temp) == 1 and temp[0] == '-1':
        break
    raw += temp
raw = list(map(int, raw))
index = 0
last = ""
while True:
    [x,y,t,l,w] = raw[index:index+5]
    house = [[0 for i in range(x)] for j in range(y)]
    index += 5
    leaks = []
    for i in range(l):
        [lx,ly] = raw[index:index+2]
        index += 2
        leaks.append(point(lx-1,ly-1))
    for i in range(w):
        [x1,y1,x2,y2] = raw[index:index+4]
        index += 4
        handle_wall(house, point(x1-1,y1-1), point(x2-1,y2-1))
    visited = [[False for i in range(x)] for j in range(y)]
    result = 0
    queue = []
    for p in leaks:
        queue.append(cell(p,1))
        x1 = p.x
        y1 = y-1-p.y
        visited[y1][x1] = True

    while len(queue) != 0:
        current = queue.pop(0)
        result += 1
        if current.min == t:
            continue
        p1 = point(current.point.x,current.point.y+1)
        if in_range(house, p1) and not_visited(visited, p1):
            set_visited(visited, p1)
            queue.append(cell(p1,current.min + 1))          
        p2 = point(current.point.x+1,current.point.y)
        if in_range(house, p2) and not_visited(visited, p2):
            set_visited(visited, p2)
            queue.append(cell(p2,current.min + 1))
        p3 = point(current.point.x,current.point.y-1)
        if in_range(house, p3) and not_visited(visited, p3):
            set_visited(visited, p3)
            queue.append(cell(p3,current.min + 1))
        p4 = point(current.point.x-1,current.point.y)
        if in_range(house, p4) and not_visited(visited, p4):
            set_visited(visited, p4)
            queue.append(cell(p4,current.min + 1))

    last = last + str(result) + "\n"
    if index == len(raw):
        break
print(last)