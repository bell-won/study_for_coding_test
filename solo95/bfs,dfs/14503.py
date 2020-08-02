from sys import stdin
from collections import deque
import copy
deque = deque()
directions = [[-1,0],[0,1],[1,0],[0,-1]]
#               북     동    남     서
N, M = map(int, stdin.readline().strip().split(' '))
r, c, d = map(int, stdin.readline().strip().split(' '))
maps = []
for _ in range(N):
    maps.append(list(map(int, stdin.readline().strip().split(' '))))
deque.append([r,c,d])
visit = copy.deepcopy(maps)
count = 0
while deque:
    r, c, d = deque.popleft()
    if visit[r][c] == 0:    
        count += 1
    visit[r][c] = count
    p = 0
    for _ in range(4):
        d = (d + 3) % 4
        nextR = r + directions[d][0]
        nextC = c + directions[d][1]
        if (0 <= nextR < N
        and 0 <= nextC < M
        and visit[nextR][nextC] == 0):
            deque.append([nextR, nextC, d])
            p += 1
            break
    if p == 0:
        nextR, nextC = directions[(d + 2) % 4]
        nextR = r + nextR
        nextC = c + nextC
        if maps[nextR][nextC] == 1:
            break
        else:
            deque.append([nextR, nextC, d])
print(count)