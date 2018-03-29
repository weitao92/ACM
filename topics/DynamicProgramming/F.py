#https://pcs.cs.cloud.vt.edu/contests/33/problems/A
rods=["A","B","C"]
result = ""
def recur(size,src,det,mid):
    global rods
    global result
    if size == 1:
        result += rods[src] + " -> " + rods[det] + "\n"
    else:
        recur(size-1,src,mid,det)
        recur(1,src,det,mid)
        recur(size-1,mid,det,src)
n = int(input())
recur(n,0,2,1)
result = result[0:len(result)-1]
print(result)