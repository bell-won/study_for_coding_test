from sys import stdin
import re
line = stdin.readline().strip()
# 정규표현식을 이용하여 0이 연속되는 부분과 1이 연속되는 부분을 추출.
findZeroGroup = re.findall('0*', line)
findOneGroup  = re.findall('1*', line)
# 추출 시 비어있는 '' 값이 생기고 이를 제거하는 과정
zeroGroupList = list(filter(lambda x:x != '', findZeroGroup))
oneGroupList  = list(filter(lambda x:x != '', findOneGroup))
print(min(len(zeroGroupList), len(oneGroupList)))