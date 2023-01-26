import heapq

def solution(priorities, location):
    answer = 0
    heap = priorities.copy()
    heap = list(map(lambda x : -x, heap))
    heapq.heapify(heap)
    priorities[location] = -priorities[location]
    flag = False
    
    while not flag:
        num = priorities.pop(0)
        if num < 0:
            flag = True
            num = -num
            
        if num == -heap[0]:
            heapq.heappop(heap)
            answer += 1
            if flag:
                return answer
        
        if flag:
            num = -num
            flag = False
            
        priorities.append(num)

    return answer