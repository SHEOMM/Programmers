import math

def solution(progresses, speeds):
    answer = []
    rest_day = []
    for p, s in zip(progresses, speeds):
        num = math.ceil((100 - p)/s)
        rest_day.append(num)

    num = 0
    prev_max = rest_day[0]
    
    for day in rest_day :
        if day > prev_max:
            answer.append(num)
            num = 1
            prev_max = day
        else:
            num += 1       
    
    answer.append(num)
    
    return answer