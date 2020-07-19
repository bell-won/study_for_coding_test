from sys import stdin
N = int(stdin.readline().strip())
names = {}
for _ in range(N):
    name = stdin.readline().strip()
    if name in names: names[name] += 1
    else: names[name] = 1
while True:
    try:
        name = stdin.readline().strip()
        names[name] -= 1
        if names[name] == 0:names.pop(name)
    except:
        break
print(list(names.keys())[0])