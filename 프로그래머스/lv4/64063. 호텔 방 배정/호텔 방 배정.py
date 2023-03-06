import sys
sys.setrecursionlimit(10**6)

def solution(k, room_number):

    dicts = {}
    for num in room_number:
        findChild(dicts, num)
    return list(dicts.keys())


def findChild(dicts, index):
    if index not in dicts:
        dicts[index] = index + 1
        return index
    empty = findChild(dicts, dicts[index])
    dicts[index] = empty + 1
    return empty