
import random


class Node(object):

    def __init__(self, value, level):
        self.value = value
        self.forward = [None] * level


class SkipList(object):

    def __init__(self, max_level):
        self.max_level = max_level
        self.head = Node(None, max_level)

    def insert(self, value):
        current = self.head
        current_column = [None] * self.max_level
        for i in range(self.max_level - 1, -1, -1):
            while current.forward[i] and current.forward[i].value < value:
                current = current.forward[i]
            current_column[i] = current

        if current.forward[0] and current.forward[0].value == value:
            return

        level = self.random_level()
        node = Node(value, level)
        for i in range(level):
            node.forward[i] = current_column[i].forward[i]
            current_column[i].forward[i] = node

    def remove(self, value):
        current = self.head
        pre_column = [Node(None, self.max_level)] * self.max_level
        for i in range(self.max_level - 1, -1, -1):
            while current.forward[i] and current.forward[i].value < value:
                current = current.forward[i]
            pre_column[i] = current

        if not current.forward[0] or (current.forward[0].value and current.forward[0].value != value):
            return

        for i in range(self.max_level):
            current_column = pre_column[i].forward[i]
            if current_column and current_column.value == value:
                pre_column[i].forward[i] = current_column.forward[i]

    def search(self, value):
        current = self.head
        for i in range(self.max_level - 1, -1, -1):
            while current.forward[i] and current.forward[i].value < value:
                current = current.forward[i]

        return current.forward[0]

    def random_level(self):
        lvl = 1
        while random.random() <= 0.5 and lvl < self.max_level:
            lvl += 1
        return lvl

    def show(self):
        head = self.head
        for level in range(self.max_level):
            print("Level {}: ".format(level), end=" ")
            node = head.forward[level]
            while node is not None:
                print(node.value, end=" ")
                node = node.forward[level]
            print("")
