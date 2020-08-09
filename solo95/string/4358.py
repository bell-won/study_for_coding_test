from sys import stdin
class Node(object):
    def __init__(self, key, data = None):
        self.key = key
        self.data = data

        self.children = {}
class Trie(object):
    def __init__(self):
        self.head = Node(None)
        self.dictionary = {}
    def insert(self, word):
        current = self.head
        for ch in word:
            if ch not in current.children:
                current.children[ch] = Node(ch)
            current = current.children[ch]
        if self.dictionary.get(word) == None:
            self.dictionary[word] = 1
        else:
            self.dictionary[word] += 1
    def getValues(self):
        for word,count in sorted(self.dictionary.items()):
            print(f'{word} {(count/len(self.dictionary))*100:.4f}')
trie = Trie()
while True:
    try:
        trie.insert(stdin.readline().strip())
    except:
        break
trie.getValues()