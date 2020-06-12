from sys import stdin
N, L = map(int, stdin.readline().strip().split(' '))
hole = list(map(int, stdin.readline().strip().split(' ')))
hole.sort()
count = 0
index = 0
while index < len(hole):
    currentIndex = index
    currentValue = hole[currentIndex]
    maxCoverDistance = currentValue + L - 0.5
    # 테이프 최대 범위를 설정하고 어디까지의 구멍까지 커버할 수 있는지 확인
    while currentIndex < len(hole):
        if hole[currentIndex] < maxCoverDistance:
            currentIndex += 1
            continue
        else:
            break
    count += 1
    if currentIndex == index: break
    else: index = currentIndex
print(count)