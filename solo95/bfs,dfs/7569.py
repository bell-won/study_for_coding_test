from sys import stdin
import collections
deque = collections.deque()
M, N, H = map(int, stdin.readline().strip().split(' '))
d = 0
box = [[stdin.readline().split() for i in range(N)] for j in range(H)] 

directions = [[-1,0,0],[0,0,1],[1,0,0],[0,1,0],[0,-1,0],[0,0,-1]]
visit = [[[1]*M for _ in range(N)] for _ in range(H)]
allTomato = M*N*H
for z in range(H):
    for y in range(N):
        for x in range(M):
            if box[z][y][x] == '1':
                deque.append((z,y,x,0))
            elif box[z][y][x] == '-1': allTomato -= 1
while deque:
    z, y, x, d = deque.popleft()
    allTomato -= 1
    for direction in directions:
        nextZ = z + direction[0]
        nextY = y + direction[1]
        nextX = x + direction[2]
        if (0 <= nextZ < H  
        and 0 <= nextY < N
        and 0 <= nextX < M
        and box[nextZ][nextY][nextX] == '0' 
        and visit[nextZ][nextY][nextX]):
            deque.append((nextZ, nextY, nextX, d+1))
            visit[nextZ][nextY][nextX] = False
print(d if allTomato == 0 else -1)