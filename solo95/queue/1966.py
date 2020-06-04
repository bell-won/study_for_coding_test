from sys import stdin
import copy
for i in range(int(stdin.readline().strip())):
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
        if priorityQueue[0][1] < max(priorityQueue, key=lambda x:x[1])[1]:
            priorityQueue.append(priorityQueue.pop(0))
        else:
            if M == priorityQueue[index][0]:
                print(currOrder)
                break
            priorityQueue.pop(0)
            currOrder += 1