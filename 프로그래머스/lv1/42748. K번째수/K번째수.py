def solution(array, commands):
    answer = []
    for arr in commands:
        list1 = array[arr[0] - 1 : arr[1]]
        list1.sort()
        answer.append(list1[arr[2] - 1])
    return answer