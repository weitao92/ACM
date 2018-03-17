#https://pcs.cs.cloud.vt.edu/contests/72/problems/A
import queue as Q

class cell:
    def __init__(self, heur, point, min):
        self.heur = heur
        self.point = point
        self.min = min
    def __eq__(self, other):
        if isinstance(other, cell):
            return self.heur == other.heur
        return NotImplemented
    def __gt__(self, other):
        if isinstance(other, cell):
            return self.heur > other.heur
        return NotImplemented
    def __ne__(self, other):
        if isinstance(other, cell):
            return self.heur != other.heur
        return NotImplemented
    def __ge__(self, other):
        if isinstance(other, cell):
            return self.heur >= other.heur
        return NotImplemented
    def __lt__(self, other):
        if isinstance(other, cell):
            return self.heur < other.heur
        return NotImplemented
    def __le__(self, other):
        if isinstance(other, cell):
            return self.heur <= other.heur
        return NotImplemented

class point:
    def __init__(self, row, col):
        self.row = row
        self.col = col

def in_range(point, n, m):
    return point.row >= 0 and point.row < n and point.col >= 0 and point.col < m

[row,col] = map(int, input().split())
world = []
result = []
start = None 
end = None
for i in range(row):
    line = input()
    temp = []
    temp1 = []
    for j in range(col):
        c = line[j:j+1]
        if c == '#':
            temp.append(-1)
        elif c == 's':
            temp.append(1)
            start = point(i,j)
        elif c == 't':
            temp.append(2)
            end = point(i,j)
        else:
            temp.append(0)
        temp1.append(None)
    world.append(temp)
    result.append(temp1)

queue = Q.PriorityQueue()
queue.put(cell(0,start,0))
while not queue.empty():
    current = queue.get(False)
    if world[current.point.row][current.point.col] == 2:
        print(result[end.row][end.col])
        break
    p1 = point(current.point.row-1,current.point.col)
    if in_range(p1,row,col) and world[p1.row][p1.col] != -1 and (result[p1.row][p1.col] == None
         or current.min+1 < result[p1.row][p1.col]):
        result[p1.row][p1.col] = current.min + 1
        heur = abs(end.row - p1.row) + abs(end.col - p1.col)
        queue.put(cell(current.min+1+heur,p1,current.min+1))
    p2 = point(current.point.row,current.point.col+1)
    if in_range(p2,row,col) and world[p2.row][p2.col] != -1 and (result[p2.row][p2.col] == None
         or current.min+1 < result[p2.row][p2.col]):
        result[p2.row][p2.col] = current.min + 1
        heur = abs(end.row - p2.row) + abs(end.col - p2.col)
        queue.put(cell(current.min+1+heur,p2,current.min+1))
    p3 = point(current.point.row+1,current.point.col)
    if in_range(p3,row,col) and world[p3.row][p3.col] != -1 and (result[p3.row][p3.col] == None
         or current.min+1 < result[p3.row][p3.col]):
        result[p3.row][p3.col] = current.min + 1
        heur = abs(end.row - p3.row) + abs(end.col - p3.col)
        queue.put(cell(current.min+1+heur,p3,current.min+1))
    p4 = point(current.point.row,current.point.col-1)
    if in_range(p4,row,col) and world[p4.row][p4.col] != -1 and (result[p4.row][p4.col] == None
         or current.min+1 < result[p4.row][p4.col]):
        result[p4.row][p4.col] = current.min + 1
        heur = abs(end.row - p4.row) + abs(end.col - p4.col)
        queue.put(cell(current.min+1+heur,p4,current.min+1))
    
                            