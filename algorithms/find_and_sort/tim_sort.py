MIN_MERGE = 32


def calc_min_run(n):
    r = 0
    while n >= MIN_MERGE:
        r |= n & 1
        n >>= 1
    return n + r


def insertion_sort(arr):
    n = len(arr)
    for i in range(n):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j = j - 1
        arr[j + 1] = key
    return arr


def merge(arr, left, mid, right):
    i = left
    j = mid + 1
    k = 0
    n = right - left + 1
    B = [0] * n
    while (i < mid + 1) and (j < right + 1):
        if arr[i] < arr[j]:
            B[k] = arr[i]
            k += 1
            i += 1
        else:
            B[k] = arr[j]
            k += 1
            j += 1

    while i < mid + 1:
        B[k] = arr[i]
        k += 1
        i += 1

    while j < right + 1:
        B[k] = arr[j]
        k += 1
        j += 1
    i = left
    for k in range(n):
        arr[i] = B[k]
        i += 1


def tim_sort(arr):
    n = len(arr)
    min_run = calc_min_run(n)
    min_run = 3

    for start in range(0, n, min_run):
        end = min(start + min_run, n)
        arr[start:end] = insertion_sort(arr[start:end])

    size = min_run
    while size < n:
        for left in range(0, n, 2 * size):
            mid = min(n - 1, left + size - 1)
            right = min((left + 2 * size - 1), (n - 1))
            if mid < right:
                merge(arr, left, mid, right)

        size = 2 * size


if __name__ == '__main__':
    arr = [3, 1, 9, 11, 6, 5, 7, 2, 4]
    tim_sort(arr)
    print(arr)
