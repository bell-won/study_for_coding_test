from sys import stdin
import copy
maxV = 0
def makeWall(wallCounts, matrix):
    if wallCounts == 0:
        makeVirus(matrix)
    else:
        for rowIndex, row in enumerate(matrix):
            for colIndex, col in enumerate(row):
                if col == 0:
                    matrix[rowIndex][colIndex] = 1
                    makeWall(wallCounts-1, matrix)
                    matrix[rowIndex][colIndex] = 0
def makeVirus(matrix):
    global maxV
    currentMatrix = copy.deepcopy(originMatrix)
    virusPoint = []
    directions = [[-1,0], [1,0], [0,1], [0,-1]]
    for rowIndex, row in enumerate(currentMatrix):
        if 2 in row:
            for colIndex, col in enumerate(row):
                if col == 2:
                    virusPoint.append([rowIndex, colIndex])
    while virusPoint:
        y, x = virusPoint.pop(0)
        for yDir, xDir in directions:
            nextY = y+yDir
            nextX = x+xDir
            if (0 <= nextY < len(currentMatrix) and 
                0 <= nextX < len(currentMatrix[0]) and
                currentMatrix[nextY][nextX] == 0):
                currentMatrix[nextY][nextX] = 2
                virusPoint.append([nextY, nextX])
    maxV = max(maxV,sum(row.count(0) for row in currentMatrix))

N, M = map(int, stdin.readline().strip().split(' '))
originMatrix = [ list(map(int, stdin.readline().strip().split(' '))) for _ in range(N)]
wall = 3
makeWall(3, originMatrix)
print(maxV)