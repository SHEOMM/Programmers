def solution(ingredient):
    answer = 0
    stage = 1
    stage_stack = []
    for num in ingredient :
        stage_stack.append(num)
        if stage_stack[-4:] == [1, 2, 3, 1] : 
            answer += 1
            for _ in range(4):
                stage_stack.pop()
        
    return answer

def get_stage(num):
    if num == 4 :
        return 1
    return num