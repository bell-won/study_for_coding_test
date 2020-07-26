from sys import stdin
R, C = map(int, stdin.readline().strip().split(' '))
maps = []
visited = [[0 for _ in range(C)] for _ in range(R)]
directions = [[-1,0],[1,0],[0,1],[0,-1]]
for _ in range(R):
    maps.append(stdin.readline().strip())
queue = set([(0,0,maps[0][0])])
maxV = 1
while len(queue) != 0:
    currX, currY, currV = queue.pop()
    for direction in directions:
        nextX = currX + direction[0]
        nextY = currY + direction[1]
        if (nextX >= 0 and nextY >= 0) and (nextX < C and nextY < R) and maps[nextY][nextX] not in currV:
            queue.add((nextX, nextY, currV + maps[nextY][nextX]))
            maxV = max(maxV, len(currV)+1)  
print(maxV)