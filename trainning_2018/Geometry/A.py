import math
[x,y] = map(int,input().split())
n = int(input())
result = 1000000.0
for i in range(n):
	[x1,y1,v] = map(int,input().split())
	length = math.sqrt(math.pow(abs(x1-x),2) + math.pow(abs(y1-y),2))
	result = min(result, length/v)
print(result)
