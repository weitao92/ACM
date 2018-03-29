#https://pcs.cs.cloud.vt.edu/contests/33/problems/B
def recur(level):
    if level == 0:
        return "-"
    else:
        result = ""
        temp = recur(level-1)
        result += temp
        for i in range(len(temp)):
            result += " "
        result += temp
        return result
while True:
    try:
        n = int(input())
        result = recur(n)
        print(result)
    except Exception as e:
        break

