#https://pcs.cs.cloud.vt.edu/contests/53/problems/A
A = input()
B = input()
first = []
second = []
for i in range(len(A)):
    first.append(A[i:i+1])
for j in range(len(B)):
    second.append(B[j:j+1])
world = [[0 for i in range(len(first)+1)] for j in range(len(second)+1)]
for row in range(1,len(second)+1):
    for col in range(1,len(first)+1):
        if second[row-1] == first[col-1]:
            world[row][col] = 1 + world[row-1][col-1]
        else:
            world[row][col] = max(world[row-1][col],world[row][col-1])
print(world[len(second)][len(first)])
