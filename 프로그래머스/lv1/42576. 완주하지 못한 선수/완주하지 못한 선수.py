def solution(participant, completion):
    dict1 = {}
    answer = ''
    for str in completion:
        if str in dict1:
            dict1[str] += 1
        else:
            dict1[str] = 1
    
    for str in participant:
        if str not in dict1 or dict1[str] == 0:
            answer = str
            break
        dict1[str] -= 1
        
    return answer