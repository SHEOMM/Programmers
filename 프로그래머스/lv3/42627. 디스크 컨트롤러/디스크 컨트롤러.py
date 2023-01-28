import heapq
import math

def solution(jobs):
    answer = 0
    dict_heap = {}
    
    jobs.sort(key = lambda x: x[0])
    
    for job in jobs:
        if job[0] in dict_heap:
            heapq.heappush(dict_heap[job[0]], job[1])
        else:
            dict_heap[job[0]] = [job[1]]
    
    cnt = 0
    current = 0


    while cnt < len(jobs):
        min_num = 1001
        min_key = -1
        
        for key in dict_heap:
            
            if key > current:
                if min_key == -1:
                    current = key
                else :
                    break

            if dict_heap[key]:
                num = heapq.heappop(dict_heap[key])
            
                if num < min_num:
                    min_num = num
                    min_key = key
                heapq.heappush(dict_heap[key], num)
                
        heapq.heappop(dict_heap[min_key])
        current += min_num
        answer += current - min_key
        cnt += 1
    
    answer /= len(jobs)
    answer = math.floor(answer)
    
    return answer