#https://pcs.cs.cloud.vt.edu/contests/74/problems/A
n = int(input())
factors = list(map(int, input().split()))
possibility = set()
possibility.add(1)
for f in factors:
    temp = set()
    for p in possibility:
        temp.add(p)
        temp.add(f*p)
    possibility = temp
result = n+1
for p in possibility:
    result = min(result, p+n//p)
print(result)