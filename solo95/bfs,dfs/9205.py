from sys import stdin
T = int(stdin.readline().strip())
print(T)
maxBeer = 20
beerPerMeter = 50
for _ in range(T):
    N = int(stdin.readline().strip())
    matrix = []
    for i in range(N+2):
        matrix.append(list(map(int, stdin.readline().strip().split(' '))))
    start = matrix.pop(0)
    checked = [start]
    queue = [start]
    flag = False
    while queue:
        x, y = queue.pop(0)
        print(matrix)
        if x == matrix[len(matrix)-1][0] and y == matrix[len(matrix)-1][1]:
            flag = True
            break
        for nextX, nextY in matrix:
            dist = abs(nextX - x) + abs(nextY - y)
            if dist <= beerPerMeter * maxBeer and [nextX, nextY] not in checked:
                queue.append([nextX, nextY])
                checked.append([nextX, nextY])
    if flag: print('happy')
    else:    print('sad')