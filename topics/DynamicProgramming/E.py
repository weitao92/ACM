#https://pcs.cs.cloud.vt.edu/problems/223
from bisect import bisect_left
n = int(input())
initial = list(map(int, input().split()))
dp = []
for i in range(n):
    pos = bisect_left(dp,initial[i])
    if pos >= len(dp):
        dp.append(initial[i])
    else:
        dp[pos] = initial[i]
print(len(dp)) 
