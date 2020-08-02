import sys
def solution(board):
    answer      = 0
    destination = len(board)-1
    directions  = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    queue       = []
    dist        = [[sys.maxsize for x in range(len(board))] for _ in range(len(board))]
    if board[0][1] == 0:
        dist[0][1] = 100
        queue.append([0,1,0,100])
    if board[1][0] == 0:
        dist[1][0] = 100
        queue.append([1,0,1,100])
    while len(queue) != 0:
        currPoint = queue.pop(0)
        currY = currPoint[0]
        currX = currPoint[1]
        for i, direction in enumerate(directions):
            nextY = currY + direction[0]
            nextX = currX + direction[1]
            if (nextX >= 0 and nextX < len(board) and
                nextY >= 0 and nextY < len(board) and board[nextY][nextX] == 0 ):
                cost = 100 if i == currPoint[2] else 600
                if dist[nextY][nextX] >= cost + currPoint[3]:
                    dist[nextY][nextX] = cost + currPoint[3]
                    queue.append([nextY, nextX, i, cost + currPoint[3]])
    
    return dist[destination][destination]