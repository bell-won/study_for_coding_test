from sys import stdin
import math
N, M = map(int, stdin.readline().strip().split(' '))
singles = []
packages = []
for case in range(M):
    packageValue, singleValue = map(int, stdin.readline().strip().split(' '))
    singles.append(singleValue)
    packages.append(packageValue)
minPackageValue = min(packages)
minSingleValue  = min(singles)
print(min(minPackageValue, minSingleValue * 6) * (N//6) + min(minSingleValue * (N%6), minPackageValue))