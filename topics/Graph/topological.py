#https://pcs.cs.cloud.vt.edu/problems/65
[n,m] = map(int, input().split())
into = [0 for i in range(n)]
graph = [[] for i in range(n)]
for i in range(m):
    [d,u] = map(int, input().split())
    graph[d-1].append(u-1)
    into[u-1] += 1
bag = []
for i in range(n):
    if into[i] == 0:
        bag.append(i)
unique = True
removed = 0
while len(bag) != 0:
    if len(bag) > 1:
        unique = False
    current = bag.pop()
    for i in graph[current]:
        into[i] -= 1
        removed += 1
        if into[i] == 0:
            bag.append(i)
if removed != m:
    print(0)
else:
    if unique:
        print(1)
    else:
        print(2)


