def solution(n, costs):
    sort  = sorted(costs, key = lambda x : x[2])
    answer = sort[0][2]
    connected = set([sort[0][0], sort[0][1]])


    while n != len(connected):
        for i in range(1, len(sort)):
            if sort[i][0] in connected and sort[i][1] in connected:
                continue
            if sort[i][0] in connected or sort[i][1] in connected:
                connected.update([sort[i][0], sort[i][1]])
                answer += sort[i][2]
                break
        
    return answer