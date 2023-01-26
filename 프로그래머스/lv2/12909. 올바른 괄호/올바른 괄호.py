def solution(s):
    answer = True
    stack = []
    for bracket in s:
        if bracket == ')':
            if not stack:
                return False
            else:
                stack.pop()
        elif bracket == '(':
            stack.append(bracket)

        
    if not stack:
        return True
    
    return False