def solution(bridge_length, weight, truck_weights):
    answer = 0
    load = 0
    sorted_weights = truck_weights
    
    current_bridge = []
    while sorted_weights or current_bridge:
        
        if current_bridge:
            for cur in current_bridge:
                cur[1] += 1

        if current_bridge and current_bridge[0][1] > bridge_length:
            cur = current_bridge.pop(0)
            load -= cur[0]
            
        if  sorted_weights and len(current_bridge) < bridge_length and load + sorted_weights[-1] <= weight:
            truck = sorted_weights.pop()
            current_bridge.append([truck, 1])
            load += truck
            
        answer += 1
        
    return answer