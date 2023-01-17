def solution(dots):
    answer = 0
    counts = []
    for i in range(4):
        for j in range(i + 1, 4):
            x = dots[i][0] - dots[j][0]
            y = dots[i][1] - dots[j][1]
            count = x/y
            counts.append(count)
    
    for i in range(4):
        sum = counts.pop()
        if sum in counts:
            answer += 1
            break
        
    return answer