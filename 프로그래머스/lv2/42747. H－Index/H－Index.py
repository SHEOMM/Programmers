def solution(citations):
    citations.sort(reverse = True)
    i = 0
    for num in citations:
        if i >= num:
            return i
        i += 1
    
    return len(citations)