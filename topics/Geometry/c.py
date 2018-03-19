#https://pcs.cs.cloud.vt.edu/contests/73/problems/C
import math
angel = 0
gap = 0.00001
[x0,y0] = map(float, input().split())
[x1,y1] = map(float, input().split())
v = float(input())
result = 0
temp = abs(x0-x1) * 9.8 / math.pow(v,2)
try:
	degree1 = math.degrees(math.asin(temp))/2
	degree2 = (180-degree1*2)/2
	print(min(degree1,degree2))
	print(max(degree1,degree2))
except Exception as e:
	print("Yell at Peter instead!")
	

