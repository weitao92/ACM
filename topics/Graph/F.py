#https://pcs.cs.cloud.vt.edu/contests/44/problems/B
class step:
    def __init__(self, next, length):
        self.next = next
        self.length = length
    
n = int(input())
result = ""
for i in range(n):
    [size,time] = map(int, input().split())
    buttons = input().split()
    for i in range(len(buttons)):
        buttons[i] = int(buttons[i])

    visited = {}
    for i in range(3601):
        visited[i] = False
    results = [None for i in range(3601)]
    queue = []
    queue.append(step(0,0))
    visited[0] = True

    while len(queue) != 0:
        current = queue.pop(0)
        results[current.next] = current.length
        for button in buttons:
            next = current.next + button
            if next < 0:
                next = 0
            if next > 3600:
                next = 3600
            if visited[next] == False:
                visited[next] = True
                queue.append(step(next, current.length + 1))
    
    if results[time] != None:
        result = result + str(results[time]) + " 0\n"
    else:
        for i in range(time + 1, 3601):
            if results[i] != None:
                result = result + str(results[i]) + " " + str(i-time) + "\n"
                break

print(result)