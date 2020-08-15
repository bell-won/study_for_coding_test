from sys import stdin

target = stdin.readline().strip()
current = stdin.readline().strip()

count = 0
maxIndex = len(current)
while True:
    nextIndex = target.find(current)
    target = target[nextIndex+maxIndex:]
    if nextIndex < 0:
        break
    else:
        count += 1
print(count)