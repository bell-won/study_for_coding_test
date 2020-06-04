from sys import stdin

N = int(stdin.readline())
queue = []
index = 0
for i in range(N):
    line = stdin.readline().strip().split(' ')
    if line[0] =='push':
        queue.append(line[1])
    if line[0] == 'pop':
        if len(queue) != 0 and len(queue)-index != 0 :
            print(queue[index])
            index += 1
        else:
            print(-1)
    if line[0] == 'size':
        print(len(queue) - index)
    if line[0] == 'empty':
        print(  1 if len(queue) == 0 or len(queue)-index == 0 else 0)
    if line[0] == 'front':
        print( -1 if len(queue) == 0 or len(queue)-index == 0 else queue[index])
    if line[0] == 'back':
        print( -1 if len(queue) == 0 or len(queue)-index == 0 else queue[len(queue)-1])