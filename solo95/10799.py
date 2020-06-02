from sys import stdin

line = stdin.readline().strip()
stickCount = 0
totalValue = 0
for i, ch in enumerate(line):
    if ch == '(':
        if line[i+1] == '(': # 막대인 경우
            stickCount +=1
        else: # 레이저인 경우
            totalValue += stickCount
    else:
        if line[i-1] == ')': # 막대 끝난 경우
            totalValue +=1
            stickCount -=1
print(totalValue)