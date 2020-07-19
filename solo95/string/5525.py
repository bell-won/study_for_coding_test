from sys import stdin

N = int(stdin.readline().strip())
M = int(stdin.readline().strip())
S = stdin.readline().strip()

Pn = "I"
count = 0

for _ in range(N):
    Pn += "OI"
maxLen = len(S)
i=0
while i < maxLen-1:
    if S[i] == "I" and S[i+1] == "O":
        countOI = 0
        while i+2 < maxLen and S[i+1] == "O" and S[i+2] == "I":
            countOI += 1
            i += 2
            if countOI == N:
                count += 1
                countOI -= 1
    i += 1
print(count)