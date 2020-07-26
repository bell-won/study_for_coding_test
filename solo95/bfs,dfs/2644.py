from sys import stdin

N = int(stdin.readline().strip())
target1, target2 = map(int, stdin.readline().strip().split(' '))
M = int(stdin.readline().strip())
graph = [[0 for _ in range(N)] for _ in range(N)]
path = [[0 for _ in range(N)] for _ in range(N)]
queue = []
visit = [target1-1]
count = 0
for _ in range(M):
    x, y = map(int, stdin.readline().strip().split(' '))
    graph[x-1][y-1] = 1
    graph[y-1][x-1] = 1
for i, v in enumerate(graph[target1-1]):
    if v != 0:
        queue.append([i,0])
while len(queue) != 0:
    curr = queue.pop(0)
    visit.append(curr[0])
    if curr[0] == target2-1:
        count = curr[1]+1
        break
    for i, v in enumerate(graph[curr[0]]):
        if v != 0 and i not in visit:
            queue.append([i,curr[1] + 1])
if count:print(count)
else:print(-1)