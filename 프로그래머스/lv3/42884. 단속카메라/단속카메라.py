def solution(routes):
    answer = 0
    sort_route = sorted(routes, key = lambda x: x[1])
    prev = sort_route[0][1]
    answer += 1
    for i in range(1, len(sort_route)):
        if prev >= sort_route[i][0]:
            continue
        prev = sort_route[i][1]
        answer += 1
    return answer