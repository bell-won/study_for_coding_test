from sys import stdin
T = int(stdin.readline())
for i in range(T):
    line = stdin.readline().strip()
    stack = []
    flag = True
    for ch in line:
        if ch =='(':
            stack.append('(')
        else:
            if len(stack) == 0:
                flag = False
                break
            stack.pop()
    if len(stack) == 0 and flag:
        print('YES')
    else:
        print('NO')