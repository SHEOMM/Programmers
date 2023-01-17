def solution(babbling):
    answer = 0
    result = []
    for str in babbling:
        s = str.replace("aya", "A")
        s = s.replace("ye", "Y")
        s = s.replace("woo", "W")
        s = s.replace("ma", "M")
        result.append(s)
        
    for str in result:
        if str != str.upper():
            continue
        start = "a"
        flag = 0
        for char in str:
            if start == char:
                flag = 1
                break
            start = char
        
        if flag == 1:
            continue
        answer += 1

    return answer