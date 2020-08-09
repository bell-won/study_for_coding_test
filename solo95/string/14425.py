from sys import stdin
class Node(object):
    def __init__(self, key, data = None):
        self.key = key
        self.data = data
        self.children = {}
class Trie(object):
    def __init__(self):
        self.head = Node(None)
    def insert(self, word):
        current = self.head
        for ch in word:
            if ch not in current.children:
                current.children[ch] = Node(ch)
            current = current.children[ch]
        current.children['*'] = True
    def search(self, word):
        current = self.head
        for ch in word:
            if ch not in current.children:
                return False
            current = current.children[ch]
        if '*' in current.children:
            return True
N, M= map(int, stdin.readline().strip().split(' '))
trie = Trie()
for _ in range(N):
    trie.insert(stdin.readline().strip())
count = 0
for _ in range(M):
    if trie.search(stdin.readline().strip()): count+=1
print(count)