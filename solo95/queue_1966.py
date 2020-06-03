from sys import stdin
import copy
tCase = int(stdin.readline().strip())
for i in range(tCase):
    line = stdin.readline().strip().split(' ')
    N = int(line[0])
    M = int(line[1])
    origin = stdin.readline().strip().split(' ')
    priorityQueue = []
    currOrder = 1
    for index, priority in enumerate(origin):
        priorityQueue.append([index,int(priority)])
    index = 0
    while(True):
        if len(list(filter(lambda x: x[1] > priorityQueue[index][1], priorityQueue[index+1:]))) > 0:
            priorityQueue.append(priorityQueue[index])
            priorityQueue = priorityQueue[index+1:]
        else:
            if M == priorityQueue[index][0]:
                print(currOrder)
                break
            priorityQueue = priorityQueue[index+1:]
            currOrder += 1