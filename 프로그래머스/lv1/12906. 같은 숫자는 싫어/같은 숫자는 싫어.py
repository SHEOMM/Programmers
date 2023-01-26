def solution(arr):
    answer = []
    answer.append(arr[0])
    
    for num in arr :
        if num == answer[-1]:
            continue
        answer.append(num)
        
    return answer