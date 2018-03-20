#https://pcs.cs.cloud.vt.edu/contests/53/problems/B
n = int(input())
initial = list(map(int, input().split()))
dp = [1 for i in range(n)]
for i in range(n):
    for j in range(i):
        if initial[i] > initial[j]:
            dp[i] = max(dp[i], 1+dp[j])
result = 0
for i in range(n):
    result = max(result, dp[i])
print(result) 