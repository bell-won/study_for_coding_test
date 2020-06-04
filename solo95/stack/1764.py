from sys import stdin
line = stdin.readline().strip().split(' ')
N = int(line[0])
M = int(line[1])
obj = {}
count = 0
names = []
for i in range(N):
    obj[stdin.readline().strip()] = 1
for i in range(M):
    target = stdin.readline().strip()
    if target in obj:
        count += 1
        names.append(target)
print(count)
names.sort()
for name in names:
    print(name)