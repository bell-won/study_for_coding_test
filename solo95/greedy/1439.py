from sys import stdin
import re
line = stdin.readline().strip()
findZero = re.findall('0*', line)
findOne  = re.findall('1*', line)
zeroList= list(filter(lambda x:x != '', findZero))
oneList= list(filter(lambda x:x != '', findOne))
print(min(len(zeroList), len(oneList)))