#https://pcs.cs.cloud.vt.edu/contests/74/problems/B
n = int(input())
grid = [[0 for i in range(n+1)]]
for row in range(1,n+1):
    grid.append([0])
    temp = list(map(int, input().split()))
    for i in temp:
        grid[row].append(i)
for row in range(1,n+1):
    for col in range(1,n+1):
        grid[row][col] += grid[row-1][col]
        grid[row][col] += grid[row][col-1]
        grid[row][col] -= grid[row-1][col-1]
result = -1000000000
for r1 in range(1,n+1):
    for r2 in range(r1, n+1):
        for c1 in range(1,n+1):
            for c2 in range(c1, n+1):
                temp = grid[r2][c2] - grid[r1-1][c2] - grid[r2][c1-1] + grid[r1-1][c1-1]
                result = max(result,temp)
print(result)