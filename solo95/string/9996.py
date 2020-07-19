from sys import stdin
N = int(stdin.readline().strip())
target = stdin.readline().strip()
starIndex = target.find('*')
before,after = target.split('*')
for _ in range(N):
    curr = stdin.readline().strip()
    if before == curr[0:len(before)] and after == curr[len(curr)-len(after):len(curr)] and len(before)<= len(curr) - len(after):print("DA")
    else:print("NE")