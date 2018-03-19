#https://pcs.cs.cloud.vt.edu/contests/73/problems/B
import sys
line = input()
stack = []
for i in range(len(line)):
	c = line[i:i+1]
	if c == '(':
		stack.append(c)
	else:
		if len(stack) == 0:
			print("Unbalanced")
			sys.exit(0)
		else:
			stack.pop()
if len(stack) == 0:
	print("Balanced")
else:
	print("Unbalanced")