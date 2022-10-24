class BitMap:
    size = 32

    def __init__(self, bit_size):
        self.bits = [0] * (bit_size // self.size + 1)

    def get(self, pos):
        return (self.bits[pos // self.size] & (1 << pos % self.size)) != 0

    def set(self, pos):
        self.bits[pos // self.size] |= (1 << pos % self.size)


if __name__ == '__main__':
    bitmap = BitMap(50)
    arr = [1, 2, 3, 11, 5, 8, 2, 3, 5, 33, 32]
    for item in arr:
        if bitmap.get(item):
            print(item, end=" ")
        else:
            bitmap.set(item)
