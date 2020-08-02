from sys import stdin
import collections
deque = collections.deque()
N = int(stdin.readline().strip())
array = []
directions = [[0,1],[0,-1],[1,0],[-1,0]]
maxHeight = 0
maxSafty = 0
for i in range(N):
    array.append(list(map(int, stdin.readline().strip().split(' '))))
    maxHeight = max(maxHeight, max(array[i]))
for currentHeight in range(0, maxHeight+1):
    currentMap = []
    count = 0
    for i, row in enumerate(array):
        currentRow = []
        for j, col in enumerate(row):
            if currentHeight <= col:
                currentRow.append(True)
                deque.append([i,j])
                count += 1
            else:  
                currentRow.append(False)
        currentMap.append(currentRow)
    if count == 0:
        break
    visit = [[ 0 for _ in range(N)] for _ in range(N)]
    saftyZone = 1
    while deque:
        y, x = deque.popleft()
        if visit[y][x] == 0:
            stack = [[y,x]]
            while stack:
                y, x = stack.pop()
                visit[y][x] = saftyZone
                for direction in directions:
                    nextY = y + direction[0]
                    nextX = x + direction[1]
                    if (nextX >= 0 and nextX < N 
                    and nextY >= 0 and nextY < N 
                    and visit[nextY][nextX] == 0
                    and currentMap[nextY][nextX] == True):
                        stack.append([nextY, nextX])
            saftyZone += 1
    maxSafty = max(saftyZone - 1, maxSafty)
print(maxSafty)