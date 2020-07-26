from sys import stdin
import collections
deque = collections.deque()


N = int(stdin.readline().strip())
visit = [[ 0 for _ in range(N)] for _ in range(N)]
graph = [list(map(int, stdin.readline().strip().split(' ')) )for _ in range(N)]
deque.append(0)
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            visit[i][j] = 1
            deque.append(j)
    while deque:
        curr = deque.popleft()
        for j in range(N):
            if graph[curr][j] == 1 and visit[i][j] != 1:
                visit[i][j] = 1
                deque.append(j)
for row in visit:
    print(" ".join(map(str, row)))