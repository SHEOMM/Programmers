def solution(s):
    count = 0
    answer = 0
    prev = "A"
    flag = True
    start = "B"
    for char in s :
        if flag :
            start = char
            count += 1
            flag = False
        elif char == start :
            count += 1
        elif char != start :
            count -= 1
            
        if count == 0:
            answer += 1
            flag = True
    if count != 0:
        answer += 1
    return answer