from sys import stdin
N = int(stdin.readline().strip())
matrix = [stdin.readline().strip() for _ in range(N)]
directions = [[0,1],[0,-1],[-1,0],[1,0]]
checkedRGB = [[0 for _ in range(N)] for _ in range(N)]
checkedRB = [[0 for _ in range(N)] for _ in range(N)]
count = 0
while sum(x.count(0) for x in checkedRGB) != 0:
    count += 1
    queue = []
    for rowIndex, row in enumerate(checkedRGB):
        if row.count(0) != 0:
            queue.append([rowIndex, row.index(0), count])
            break
    checkedRGB[queue[0][0]][queue[0][1]]=count
    while queue:
        y, x, v = queue.pop(0)
        for direction in directions:
            nextY = direction[0] + y
            nextX = direction[1] + x
            if 0 <= nextY < N and 0 <= nextX < N and checkedRGB[nextY][nextX] == 0:
                if matrix[y][x] == matrix[nextY][nextX]:
                    checkedRGB[nextY][nextX] = v
                    queue.append([nextY,nextX, v])             
count = 0
while sum(x.count(0) for x in checkedRB) != 0:
    count += 1
    queue = []
    for rowIndex, row in enumerate(checkedRB):
        if row.count(0) != 0:
            queue.append([rowIndex, row.index(0), count])
            break
    checkedRB[queue[0][0]][queue[0][1]]=count
    while queue:
        y, x, v = queue.pop(0)
        for direction in directions:
            nextY = direction[0] + y
            nextX = direction[1] + x
            if 0 <= nextY < N and 0 <= nextX < N and checkedRB[nextY][nextX] == 0:
                if matrix[y][x] == matrix[nextY][nextX]:
                    checkedRB[nextY][nextX] = v
                    queue.append([nextY,nextX, v])
                if (matrix[y][x] == 'G' and matrix[nextY][nextX] == 'R' or
                    matrix[y][x] == 'R' and matrix[nextY][nextX] == 'G'):
                    checkedRB[nextY][nextX] = v
                    queue.append([nextY,nextX, v])
print(max(max(x) for x in checkedRGB))
print(max(max(x) for x in checkedRB))