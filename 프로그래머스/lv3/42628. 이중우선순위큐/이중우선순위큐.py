import heapq

def solution(operations):
    answer = []
    heap = []
    for opr in operations :
        if opr[0] == "I":
            num = int(opr[1:])
            heapq.heappush(heap, num)

        elif opr[0] == "D":
            if len(heap) == 0:
                continue
            elif len(opr) == 3:
                heap.pop(heap.index(heapq.nlargest(1, heap)[0]))
            elif len(opr) == 4:
                heapq.heappop(heap)
    if len(heap) == 0 :
        return [0, 0]
            
    return [heapq.nlargest(1, heap)[0], heap[0]]