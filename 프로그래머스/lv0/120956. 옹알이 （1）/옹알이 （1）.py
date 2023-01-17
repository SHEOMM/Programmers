def solution(babbling):
    answer = 0
    for str in babbling :
        length = len(str)
        if str.find("aya") != -1 : 
            length -= 3
        if str.find("ye") != -1 :
            length -= 2
        if str.find("woo") != -1 :
            length -= 3
        if str.find("ma") != -1 :
            length -= 2
        
        if length == 0:
            answer += 1
        
    return answer