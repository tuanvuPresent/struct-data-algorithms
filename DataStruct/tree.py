class TreeNode:
    def __init__(self, data):
        self.data = data
        self.parent = None
        self.children = []

    def add_children(self, child):
        child.parent = self
        self.children.append(child)

    def get_level(self):
        level = 0
        p = self.parent
        while p:
            level += 1
            p = p.parent

        return level

    def print_tree(self):
        print(' ' * self.get_level() + self.data)
        if self.children:
            for child in self.children:
                child.print_tree()


def build_tree():
    n = 3
    root = TreeNode('root')

    a = TreeNode('a')
    for i in range(n):
        a.add_children(TreeNode('a' + str(i)))

    a1 = TreeNode('a1')
    for i in range(n):
        a1.add_children(TreeNode('a1-' + str(i)))
    a.add_children(a1)

    b = TreeNode('b')
    for i in range(n):
        b.add_children(TreeNode('b' + str(i)))

    c = TreeNode('c')
    for i in range(n):
        c.add_children(TreeNode('c' + str(i)))

    root.add_children(a)
    root.add_children(b)
    root.add_children(c)

    root.print_tree()
